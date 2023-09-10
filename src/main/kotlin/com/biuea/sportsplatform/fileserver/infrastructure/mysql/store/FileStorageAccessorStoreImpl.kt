package com.biuea.sportsplatform.fileserver.infrastructure.mysql.store

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor
import com.biuea.sportsplatform.fileserver.domain.store.FileStorageAccessorStore
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.toDomain
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.toEntity
import com.biuea.sportsplatform.fileserver.infrastructure.mysql.repository.FileStorageAccessorRepository
import org.springframework.stereotype.Component

@Component
class FileStorageAccessorStoreImpl(
    private val fileStorageAccessorRepository: FileStorageAccessorRepository
): FileStorageAccessorStore {
    override fun save(fileStorageAccessor: FileStorageAccessor): FileStorageAccessor =
        fileStorageAccessorRepository.save(fileStorageAccessor.toEntity()).toDomain()
}