package com.biuea.sportsplatform.fileserver.domain.store

import java.io.InputStream

interface PdfFileStore {
    fun writePdf(
        inputStream: InputStream,
        size: Long,
        basePath: String,
        key: String,
        extension: String
    )
}