package com.biuea.sportsplatform.fileserver.domain.command

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonFileStorageAccessorRequest

open class UploadObjectBaseCommand(
    val builder: CommonFileStorageAccessorRequest
) 