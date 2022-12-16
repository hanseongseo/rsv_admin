package com.xcape.rsv_admin.controller.response;

import com.xcape.rsv_admin.domain.dto.MerchantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class MerchantResponse {

    private Long id;
    private Long adminId;
    private String name;
    private String address;

    private List<ThemeResponse> themeResponseList;

    public static MerchantResponse fromDto(MerchantDto dto) {
        return new MerchantResponse(
                dto.getId(),
                dto.getAdminId(),
                dto.getName(),
                dto.getAddress(),
                dto.getThemeDtoList().stream().map(ThemeResponse::fromDto).toList()
        );
    }
}
