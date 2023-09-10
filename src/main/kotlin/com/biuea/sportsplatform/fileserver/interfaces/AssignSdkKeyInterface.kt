package com.biuea.sportsplatform.fileserver.interfaces

import java.time.ZonedDateTime

interface AssignSdkKeyInterface {
    fun assignSdkKey(
        requestUserId: Long,
        requestUserEmail: String,
        expirationDate: ZonedDateTime
    ): String
}