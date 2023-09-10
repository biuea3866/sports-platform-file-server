package com.biuea.sportsplatform.fileserver.domain.model

import com.biuea.sportsplatform.fileserver.domain.utils.FileUtils
import java.time.ZonedDateTime

data class FileStorage(
    val id: Long,
    val filename: String,
    val extension: String,
    val size: Long,
    val absolutePath: String,
    val uploaderId: Long,
    val createDate: ZonedDateTime,
    val updateDate: ZonedDateTime
) {
    companion object {
        fun create(
            key: String,
            size: Long,
            uploadId: Long,
            basePath: String,
        ): FileStorage {
            return FileStorage(
                id = 0,
                filename = FileUtils.extractFilename(key),
                extension = FileUtils.extractExtension(key),
                size = size,
                absolutePath = FileUtils.generateAbsolutePath(
                    basePath = basePath,
                    key = key
                ),
                uploaderId = uploadId,
                createDate = ZonedDateTime.now(),
                updateDate = ZonedDateTime.now()
            )
        }
    }
}