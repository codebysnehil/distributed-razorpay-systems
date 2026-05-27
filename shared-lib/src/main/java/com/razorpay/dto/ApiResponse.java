package com.razorpay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final boolean success;
    private final T data;
    private final String error;
    private final String errorCode;

    private ApiResponse(boolean success, T data, String error, String errorCode) {
        this.success = success;
        this.data = data;
        this.error = error;
        this.errorCode = errorCode;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, data, null, null);
    }

    public static <T> ApiResponse<T> error(String errorCode, String message) {
        return new ApiResponse<>(false, null, message, errorCode);
    }

    public boolean isSuccess()    { return success; }
    public T getData()            { return data; }
    public String getError()      { return error; }
    public String getErrorCode()  { return errorCode; }
}
