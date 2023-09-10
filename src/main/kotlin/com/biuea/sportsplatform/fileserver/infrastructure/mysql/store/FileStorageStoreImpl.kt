package com.biuea.sportsplatform.fileserver.infrastructure.mysql.store

import com.biuea.sportsplatform.fileserver.domain.model.FileStorage
import com.biuea.sportsplatform.fileserver.domain.store.FileStorageStore
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.toDomain
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.toEntity
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.repository.FileStorageRepository
import org.springframework.stereotype.Component

@Component
class FileStorageStoreImpl(
    private val fileStorageRepository: FileStorageRepository
): FileStorageStore {
    override fun save(fileStorage: FileStorage): FileStorage =
        fileStorageRepository.save(fileStorage.toEntity()).toDomain()
}