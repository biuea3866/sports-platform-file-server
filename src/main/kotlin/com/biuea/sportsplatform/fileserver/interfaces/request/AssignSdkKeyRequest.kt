package com.biuea.sportsplatform.fileserver.interfaces.request

import java.time.ZonedDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class AssignSdkKeyRequest(
    @field:NotNull(message = "유저 ID는 필수입니다.")
    val requestUserId: Long,
    @field:Email(message = "올바른 이메일 형식이 아닙니다.")
    val requestUserEmail: String,
    @field:NotNull(message = "만료일은 필수입니다.")
    val expirationDate: ZonedDateTime
) {
}