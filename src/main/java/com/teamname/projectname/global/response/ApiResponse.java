package com.teamname.projectname.global.response;

public class ApiResponse<T> {
    private boolean status;
    private String message;
    private T data;
    private Object metadata;

    public ApiResponse(boolean status, String message, T data, Object metadata) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Request successful", data, null);
    }

    public static <T> ApiResponse<T> success(T data, Object metadata) {
        return new ApiResponse<>(true, "Request successful", data, metadata);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(false, message, null, null);
    }
}
