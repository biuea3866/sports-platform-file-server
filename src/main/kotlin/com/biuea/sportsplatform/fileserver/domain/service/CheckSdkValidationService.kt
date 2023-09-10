package com.biuea.sportsplatform.fileserver.domain.service

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor
import com.biuea.sportsplatform.fileserver.domain.reader.FileStorageAccessorReader
import org.springframework.stereotype.Service

@Service
class CheckSdkValidationService(
    private val fileStorageAccessorReader: FileStorageAccessorReader
) {
    fun execute(sdkKey: String): FileStorageAccessor {
        val accessor = this.fileStorageAccessorReader.findAccessor(sdkKey)
        accessor.checkAvailableSdkKey()
        return accessor
    }
}