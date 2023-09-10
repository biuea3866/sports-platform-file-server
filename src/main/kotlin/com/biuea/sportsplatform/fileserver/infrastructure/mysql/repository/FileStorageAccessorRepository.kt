package com.biuea.sportsplatform.fileserver.infrastructure.mysql.repository

import com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity.FileStorageAccessorEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FileStorageAccessorRepository: JpaRepository<FileStorageAccessorEntity, Long> {
    fun findBySdkKey(sdkKey: String): FileStorageAccessorEntity?
    fun findByUserId(userId: Long): FileStorageAccessorEntity?
}