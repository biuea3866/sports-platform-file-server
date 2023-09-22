package com.biuea.sportsplatform.fileserver.domain.enums

enum class FileStorageAccessStatus {
    VALID,
    EXPIRED,
    FORBIDDEN
    ;
}

fun FileStorageAccessStatus.notAvailableStatus() =
    this == FileStorageAccessStatus.EXPIRED || this == FileStorageAccessStatus.FORBIDDEN