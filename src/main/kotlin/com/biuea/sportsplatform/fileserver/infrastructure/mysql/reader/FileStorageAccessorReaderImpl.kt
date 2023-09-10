package com.biuea.sportsplatform.fileserver.infrastructure.mysql.reader

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor
import com.biuea.sportsplatform.fileserver.domain.reader.FileStorageAccessorReader
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.toDomain
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.repository.FileStorageAccessorRepository
import org.springframework.stereotype.Component

@Component
class FileStorageAccessorReaderImpl(
    private val fileStorageAccessorRepository: FileStorageAccessorRepository
): FileStorageAccessorReader {
    override fun findAccessor(sdkKey: String): FileStorageAccessor =
        this.fileStorageAccessorRepository.findBySdkKey(sdkKey)?.toDomain()
            ?: throw IllegalArgumentException("Invalid SDK Key")
}