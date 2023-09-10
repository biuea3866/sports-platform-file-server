package com.biuea.sportsplatform.fileserver.domain.command

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor
import java.time.ZonedDateTime

class AssignSdkKeyCommand(
    val requestUserId: Long,
    val requestUserEmail: String,
    val expirationDate: ZonedDateTime
) {
    fun toModel(): FileStorageAccessor {
        return FileStorageAccessor.create(
            email = this.requestUserEmail,
            userId = this.requestUserId,
            expirationDate = this.expirationDate
        )
    }
}