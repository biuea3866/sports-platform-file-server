package com.biuea.sportsplatform.fileserver.domain.utils

import java.util.UUID

object KeyGenerator {
    fun generateSdkKey(): String {
        return UUID.randomUUID().toString()
    }
}