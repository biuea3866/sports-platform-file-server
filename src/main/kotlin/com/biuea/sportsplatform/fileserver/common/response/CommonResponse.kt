package com.biuea.sportsplatform.fileserver.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class CommonResponse<T>(
    val success: Boolean,
    val code: HttpStatus,
    val message: String?,
    val data: T?
) {
    companion object {
        fun<T> success(
            data: T?,
            code: HttpStatus,
            message: String?
        ): CommonResponse<T> {
            return CommonResponse(
                success = true,
                code = code,
                message = message,
                data = data
            )
        }

        fun<T> success(
            data: T?,
            code: HttpStatus,
        ): CommonResponse<T> {
            return CommonResponse(
                success = true,
                code = code,
                message = null,
                data = data
            )
        }
    }
}
