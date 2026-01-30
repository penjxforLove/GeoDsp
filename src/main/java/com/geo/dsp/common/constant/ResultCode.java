package com.geo.dsp.common.constant;

/**
 * 响应结果状态码枚举
 */
public enum ResultCode {
    /** 成功 */
    SUCCESS(200, "成功"),
    /** 失败 */
    FAIL(500, "失败"),
    /** 未授权 */
    UNAUTHORIZED(401, "未授权"),
    /** 禁止访问 */
    FORBIDDEN(403, "禁止访问"),
    /** 资源不存在 */
    NOT_FOUND(404, "资源不存在"),
    /** 请求参数错误 */
    PARAM_ERROR(400, "请求参数错误");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}