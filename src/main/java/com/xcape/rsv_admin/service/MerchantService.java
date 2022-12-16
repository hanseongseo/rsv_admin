package com.xcape.rsv_admin.service;

import com.xcape.rsv_admin.domain.dto.MerchantDto;
import com.xcape.rsv_admin.domain.dto.ThemeDto;
import com.xcape.rsv_admin.domain.entity.Admin;
import com.xcape.rsv_admin.domain.entity.Merchant;
import com.xcape.rsv_admin.domain.entity.Theme;
import com.xcape.rsv_admin.repository.MerchantRepository;
import com.xcape.rsv_admin.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;
    private final ThemeRepository themeRepository;

    @Transactional
    public List<MerchantDto> getMerchantsByAdmin(Admin admin) {
        List<Merchant> merchantByUserId = merchantRepository.findMerchantsByAdmin(admin);

        return merchantByUserId.stream()
                .map(this::merchantToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public MerchantDto getMerchant(Long merchantId) {
        Optional<Merchant> optional = merchantRepository.findById(merchantId);
        assert optional.isPresent();

        return merchantToDto(optional.get());
    }

    //  테스트용
    @Transactional
    public List<MerchantDto> getAllMerchants() {
        List<Merchant> merchantByUserId = merchantRepository.findAll();

        return merchantByUserId.stream()
                .map(this::merchantToDto)
                .collect(Collectors.toList());
    }

    private MerchantDto merchantToDto(Merchant merchant) {
        List<ThemeDto> collect = themeRepository.findThemesByMerchant(merchant).stream().map(ThemeDto::fromEntity).toList();
        return new MerchantDto(merchant.getId(), merchant.getAdmin().getId(), merchant.getName(), merchant.getAddress(), collect);
    }
}
