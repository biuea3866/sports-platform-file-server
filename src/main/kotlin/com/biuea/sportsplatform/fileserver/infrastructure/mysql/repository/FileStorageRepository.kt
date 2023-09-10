package com.biuea.sportsplatform.fileserver.infrastructure.mysql.repository

import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.FileStorageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FileStorageRepository: JpaRepository<FileStorageEntity, Long> {
}