package com.biuea.sportsplatform.fileserver.domain.store

import com.biuea.sportsplatform.fileserver.domain.model.FileStorage

interface FileStorageStore {
    fun save(fileStorage: FileStorage): FileStorage
}