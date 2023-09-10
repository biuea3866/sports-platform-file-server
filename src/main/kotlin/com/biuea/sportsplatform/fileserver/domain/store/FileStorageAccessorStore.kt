package com.biuea.sportsplatform.fileserver.domain.store

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor

interface FileStorageAccessorStore {
    fun save(fileStorageAccessor: FileStorageAccessor): FileStorageAccessor
}