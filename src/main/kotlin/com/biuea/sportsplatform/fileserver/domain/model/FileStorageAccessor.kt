package com.biuea.sportsplatform.fileserver.domain.model

import com.biuea.sportsplatform.fileserver.domain.enums.FileStorageAccessStatus
import java.time.ZonedDateTime

data class FileStorageAccessor(
    val id : Long,
    val userId : Long,
    val email: String,
    val expirationDate: ZonedDateTime,
    val sdkKey: String,
    val status: FileStorageAccessStatus,
    val createDate: ZonedDateTime,
    val updateDate: ZonedDateTime
) {
    fun checkAvailableSdkKey() {
        if (createDate.isAfter(expirationDate)) {
            throw IllegalArgumentException("SDK Key is expired")
        }

        when (this.status) {
            FileStorageAccessStatus.VALID -> return
            FileStorageAccessStatus.EXPIRED -> {
                throw IllegalArgumentException("SDK Key is expired")
            }
            FileStorageAccessStatus.FORBIDDEN -> {
                throw IllegalArgumentException("SDK Key is forbidden")
            }
        }
    }
}