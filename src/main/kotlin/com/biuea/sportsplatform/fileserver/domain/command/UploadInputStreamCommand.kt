package com.biuea.sportsplatform.fileserver.domain.command

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor
import com.biuea.sportsplatform.fileserver.interfaces.request.CommonFileStorageAccessorRequest
import java.io.InputStream

class UploadInputStreamCommand (
    builder: CommonFileStorageAccessorRequest,
    val inputStream: InputStream,
    val size: Long,
    val accessor: FileStorageAccessor
): UploadObjectBaseCommand(builder)