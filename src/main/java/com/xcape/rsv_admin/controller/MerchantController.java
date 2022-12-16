package com.xcape.rsv_admin.controller;

import com.xcape.rsv_admin.controller.response.ThemeResponse;
import com.xcape.rsv_admin.domain.dto.MerchantDto;
import com.xcape.rsv_admin.domain.dto.ThemeDto;
import com.xcape.rsv_admin.domain.entity.Admin;
import com.xcape.rsv_admin.controller.response.ErrorCode;
import com.xcape.rsv_admin.controller.response.MerchantResponse;
import com.xcape.rsv_admin.controller.response.Response;
import com.xcape.rsv_admin.service.MerchantService;
import com.xcape.rsv_admin.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MerchantController {

    private final MerchantService merchantService;
    private final ThemeService themeService;

    @GetMapping("/merchants/{merchantId}")
    public Response<MerchantResponse> getMerchant(Admin admin, @PathVariable Long merchantId) {
        MerchantResponse response = MerchantResponse.fromDto(merchantService.getMerchant(merchantId));
        return Response.success(response);
    }

    @GetMapping("/merchants")
    public Response<List<MerchantResponse>> getMerchants(Admin admin) {
        try {
            List<MerchantResponse> merchantResponseList = merchantService.getMerchantsByAdmin(admin).stream().map(MerchantResponse::fromDto).toList();
            return Response.success(merchantResponseList);
        } catch (Exception e) {
            return Response.error(ErrorCode.INVALID_PERMISSION);
        }
    }

    @GetMapping("/all-merchants")
    public Response<List<MerchantResponse>> getAllMerchants() {
        try {
            List<MerchantResponse> merchantResponseList = merchantService.getAllMerchants().stream().map(MerchantResponse::fromDto).toList();
            return Response.success(merchantResponseList);
        } catch (Exception e) {
            return Response.error(ErrorCode.INVALID_PERMISSION);
        }
    }
}
