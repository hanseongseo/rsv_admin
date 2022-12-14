package com.xcape.rsv_admin.service;

import com.xcape.rsv_admin.domain.dto.ThemeDto;
import com.xcape.rsv_admin.domain.entity.Admin;
import com.xcape.rsv_admin.domain.entity.Merchant;
import com.xcape.rsv_admin.domain.entity.Theme;
import com.xcape.rsv_admin.repository.MerchantRepository;
import com.xcape.rsv_admin.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final MerchantRepository merchantRepository;


    @Transactional
    public List<ThemeDto> getThemesByMerchantId(Admin admin, Long merchantId) {
        //  검증
        Optional<Merchant> optional = merchantRepository.findById(merchantId);
        assert optional.isPresent();

        Merchant merchant = optional.get();
        return themeRepository.findThemesByMerchant(merchant).stream().map(ThemeDto::fromEntity).toList();
    }

    @Transactional
    public void createThemeByMerchantId(Long merchantId, ThemeDto dto) {
        dto.setMerchantId(merchantId);
        themeRepository.save(toEntity(dto));
    }

    @Transactional
    public ThemeDto getThemeByThemeId(Long themeId) {
        //  검증
        Optional<Theme> optional = themeRepository.findById(themeId);
        assert optional.isPresent();

        return ThemeDto.fromEntity(optional.get());
    }

    @Transactional
    public void deleteThemeById(Long themeId) {
        //  검증
        assert themeRepository.findById(themeId).isPresent();

        themeRepository.deleteById(themeId);
    }

    @Transactional
    public void modifyThemeById(Long themeId, ThemeDto dto) {
        //  검증
        assert themeRepository.findById(themeId).isPresent();

        themeRepository.modifyThemeById(themeId, dto.getName(), dto.getMainImage(), dto.getBgImage(), dto.getPrice(), dto.getDescription(), dto.getReasoning(), dto.getObservation(), dto.getActivity(), dto.getTeamwork(), dto.getMinPersonnel(), dto.getMaxPersonnel(), dto.getDifficulty(), dto.getGenre(), dto.getPoint(), dto.getYoutubeLink(), dto.getColorCode(), dto.getHasXKit(), dto.getIsCrimeScene());
    }

    //  merchantId 에 해당하는 merchant 가 없을 시 AssertionError 발생
    private Theme toEntity(ThemeDto dto) {
        assert merchantRepository.findById(dto.getMerchantId()).isPresent();
        return Theme.of(
                merchantRepository.findById(dto.getMerchantId()).get(),
                dto.getName(),
                dto.getMainImage(),
                dto.getBgImage(),
                dto.getPrice(),
                dto.getDescription(),
                dto.getReasoning(),
                dto.getObservation(),
                dto.getActivity(),
                dto.getTeamwork(),
                dto.getMinPersonnel(),
                dto.getMaxPersonnel(),
                dto.getDifficulty(),
                dto.getGenre(),
                dto.getPoint(),
                dto.getYoutubeLink(),
                dto.getColorCode(),
                dto.getHasXKit(),
                dto.getIsCrimeScene()
        );
    }
}
