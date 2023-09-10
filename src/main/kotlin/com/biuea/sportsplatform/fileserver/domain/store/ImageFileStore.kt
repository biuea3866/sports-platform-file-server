package com.biuea.sportsplatform.fileserver.domain.store

import java.io.InputStream

interface ImageFileStore {
    fun writeImage(
        inputStream: InputStream,
        size: Long,
        basePath: String,
        key: String,
        extension: String
    )
}