package com.xcape.rsv_admin.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INVALID_PERMISSION("Permission is invalid"),


    ;

    private String errorCode;
}
