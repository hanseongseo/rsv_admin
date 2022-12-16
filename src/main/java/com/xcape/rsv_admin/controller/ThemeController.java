package com.xcape.rsv_admin.controller;

import com.xcape.rsv_admin.controller.request.ThemeCreateRequest;
import com.xcape.rsv_admin.controller.request.ThemeModifyRequest;
import com.xcape.rsv_admin.controller.response.MerchantResponse;
import com.xcape.rsv_admin.controller.response.ThemeResponse;
import com.xcape.rsv_admin.domain.dto.ThemeDto;
import com.xcape.rsv_admin.domain.entity.Admin;
import com.xcape.rsv_admin.controller.response.Response;
import com.xcape.rsv_admin.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping("/merchants/{merchantId}")
    public Response<List<ThemeResponse>> getThemesByMerchant(Admin admin, @PathVariable Long merchantId) {
        List<ThemeResponse> themeResponseList = themeService.getThemesByMerchantId(admin, merchantId).stream().map(ThemeResponse::fromDto).toList();
        return Response.success(themeResponseList);
    }

    @PostMapping("/merchants/{merchantId}/themes")
    public Response<Void> createThemeByMerchantId(@PathVariable Long merchantId, @RequestBody ThemeCreateRequest request) {
        ThemeDto dto = ThemeDto.fromCreateRequest(request);
        themeService.createThemeByMerchantId(merchantId, dto);
        return Response.success();
    }

    @GetMapping("/themes/{themeId}")
    public Response<ThemeResponse> getThemeByThemeId(@PathVariable Long themeId) {
        return Response.success(ThemeResponse.fromDto(themeService.getThemeByThemeId(themeId)));
    }

    @PutMapping("/themes/{themeId}")
    public Response<Void> modifyThemeById(@PathVariable Long themeId, @RequestBody ThemeModifyRequest request) {
        ThemeDto dto = ThemeDto.fromModifyRequest(request);
        themeService.modifyThemeById(themeId, dto);
        return Response.success();
    }

    @DeleteMapping("/themes/{themeId}")
    public Response<Void> deleteThemeById(@PathVariable Long themeId) {
        themeService.deleteThemeById(themeId);
        return Response.success();
    }
}
