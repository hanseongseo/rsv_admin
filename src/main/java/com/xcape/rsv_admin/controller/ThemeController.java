package com.xcape.rsv_admin.controller;

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
    public Response<List<ThemeDto>> getThemesByMerchant(Admin admin, @PathVariable Long merchantId) {
        return Response.success(themeService.getThemesByMerchantId(admin, merchantId));
    }

    @PostMapping("/merchants/{merchantId}/themes")
    public Response<Void> createThemeByMerchantId(@PathVariable Long merchantId, @RequestBody ThemeDto themeDto) {
        themeService.createThemeByMerchantId(merchantId, themeDto);
        return Response.success();
    }

    @GetMapping("/themes/{themeId}")
    public Response<ThemeDto> getThemeByThemeId(@PathVariable Long themeId) {
        return Response.success(themeService.getThemeByThemeId(themeId));
    }
}
