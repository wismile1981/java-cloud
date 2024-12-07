package com.example.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String msg;
    private String code;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code("0")
                .msg("OK")
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(String msg, T data) {
        return ApiResponse.<T>builder()
                .code("0")
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(String code, String msg) {
        return ApiResponse.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }
}
