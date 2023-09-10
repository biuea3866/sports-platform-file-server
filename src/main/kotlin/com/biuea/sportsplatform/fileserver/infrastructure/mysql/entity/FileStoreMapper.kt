package com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity

import com.biuea.sportsplatform.fileserver.domain.model.FileStorage
import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor

fun FileStorageAccessorEntity.toDomain(): FileStorageAccessor = FileStorageAccessor(
    id = this.id,
    userId = this.userId,
    email = this.email,
    expirationDate = this.expirationDate,
    sdkKey = this.sdkKey,
    status = this.status,
    createDate = this.createDate,
    updateDate = this.updateDate
)

fun FileStorageAccessor.toEntity(): FileStorageAccessorEntity = FileStorageAccessorEntity(
    id = this.id,
    userId = this.userId,
    email = this.email,
    expirationDate = this.expirationDate,
    sdkKey = this.sdkKey,
    status = this.status,
    createDate = this.createDate,
    updateDate = this.updateDate
)

fun FileStorageEntity.toDomain(): FileStorage = FileStorage(
    id = this.id,
    filename = this.filename,
    extension = this.extension,
    size = this.size,
    absolutePath = this.absolutePath,
    uploaderId = this.uploaderId,
    createDate = this.createDate,
    updateDate = this.updateDate
)

fun FileStorage.toEntity(): FileStorageEntity = FileStorageEntity(
    id = this.id,
    filename = this.filename,
    extension = this.extension,
    size = this.size,
    absolutePath = this.absolutePath,
    uploaderId = this.uploaderId,
    createDate = this.createDate,
    updateDate = this.updateDate
)