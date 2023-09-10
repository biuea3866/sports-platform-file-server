package com.biuea.sportsplatform.fileserver.domain.command

import com.biuea.sportsplatform.fileserver.domain.model.FileStorageAccessor
import com.biuea.sportsplatform.fileserver.interfaces.request.CommonRequestBuilder
import java.io.InputStream

class UploadInputStreamCommand(
    builder: CommonRequestBuilder,
    val inputStream: InputStream,
    val size: Long,
    val accessor: FileStorageAccessor
): UploadObjectBaseCommand(builder)