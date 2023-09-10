package com.biuea.sportsplatform.fileserver.interfaces.request

data class CommonFileStorageAccessorRequest(
    val sdkKey: String,
    val bucket: String,
    val key: String
) {
}