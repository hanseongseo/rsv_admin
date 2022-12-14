package com.xcape.rsv_admin.repository;

import com.xcape.rsv_admin.domain.entity.Merchant;
import com.xcape.rsv_admin.domain.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    List<Theme> findAll();

    List<Theme> findThemesByMerchant(Merchant merchant);

    void deleteById(Long id);
}