package com.biuea.sportsplatform.fileserver.domain.reader

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor

interface FileStorageAccessorReader {
    fun findAccessor(sdkKey: String): FileStorageAccessor
}