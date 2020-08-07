package com.zz.common.result;

import lombok.*;

/**
 * 项目名称:     zz-common
 * 类名称:       ResultStateEnum
 * 创建时间:     2020/8/4 16:59
 * 版本:         1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultStateEnum {

    SUCCESS(200,"success"),
    ERROR(400,"error"),
    //1000以内是系统错误，
    REQUEST_PARAM_IS_NULL(1000,"请求参数为空"),
    REQUEST_INVALID_PARAM(1001,"请求参数有误"),
    ADMIN_IS_EXISTED(1002,"管理员账号已经存在"),
    UPLOAD_FILE_TOO_LARGE(1010,"上传的文件太大"),
    UPLOAD_FILE_STORE_ERROR(1011,"文件存储异常"),
    USER_IS_FORBIDEN(1401,"用户已经被禁言"),

    // --- 4xx Client Error ---
    http_status_bad_request(400, "fail"),
    http_status_unauthorized(401, "Unauthorized"),
    http_status_payment_required(402, "Payment Required"),
    http_status_forbidden(403, "Forbidden"),
    http_status_not_found(404, "Not Found"),
    http_status_method_not_allowed(405, "Method Not Allowed"),
    http_status_not_acceptable(406, "Not Acceptable"),
    http_status_proxy_authentication_required(407, "Proxy Authentication Required"),
    http_status_request_timeout(408, "Request Timeout"),
    http_status_conflict(409, "Conflict"),
    http_status_gone(410, "Gone"),
    http_status_length_required(411, "Length Required"),
    http_status_precondition_failed(412, "Precondition Failed"),
    http_status_payload_too_large(413, "Payload Too Large"),
    http_status_uri_too_long(414, "URI Too Long"),
    http_status_unsupported_media_type(415, "Unsupported Media Type"),
    http_status_requested_range_not_satisfiable(416, "Requested range not satisfiable"),
    http_status_expectation_failed(417, "Expectation Failed"),
    http_status_im_a_teapot(418, "I'm a teapot"),
    http_status_unprocessable_entity(422, "Unprocessable Entity"),
    http_status_locked(423, "Locked"),
    http_status_failed_dependency(424, "Failed Dependency"),
    http_status_upgrade_required(426, "Upgrade Required"),
    http_status_precondition_required(428, "Precondition Required"),
    http_status_too_many_requests(429, "Too Many Requests"),
    http_status_request_header_fields_too_large(431, "Request Header Fields Too Large"),

    // --- 5xx Server Error ---
    http_status_internal_server_error(500, "系统错误"),
    http_status_not_implemented(501, "Not Implemented"),
    http_status_bad_gateway(502, "Bad Gateway"),
    http_status_service_unavailable(503, "Service Unavailable"),
    http_status_gateway_timeout(504, "Gateway Timeout"),
    http_status_http_version_not_supported(505, "HTTP Version not supported"),
    http_status_variant_also_negotiates(506, "Variant Also Negotiates"),
    http_status_insufficient_storage(507, "Insufficient Storage"),
    http_status_loop_detected(508, "Loop Detected"),
    http_status_bandwidth_limit_exceeded(509, "Bandwidth Limit Exceeded"),
    http_status_not_extended(510, "Not Extended"),
    http_status_network_authentication_required(511, "Network Authentication Required");;

    // 返回的状态码
    int code;
    // 返回的消息描述
    String message;

}
