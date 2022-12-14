package com.xcape.rsv_admin.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * A DTO for the {@link com.xcape.rsv_admin.domain.entity.Merchant} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MerchantDto {
    private Long id;
    private Long adminId;
    private String name;
    private String address;

    private List<ThemeDto> themeDtoList;

    public MerchantDto(Long id, Long adminId, String name, String address) {
        this.id = id;
        this.adminId = adminId;
        this.name = name;
        this.address = address;
    }
}