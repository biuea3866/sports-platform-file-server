package com.biuea.sportsplatform.fileserver.domain.utils

import java.io.File

object FileUtils {
    fun generateAbsolutePath(
        basePath: String,
        key: String
    ) = basePath + key

    fun extractExtension(key: String): String {
        return key.substring(key.lastIndexOf('.') + 1)
    }

    fun extractFilename(key: String): String {
        return key.substring(0, key.lastIndexOf("."))
    }
}