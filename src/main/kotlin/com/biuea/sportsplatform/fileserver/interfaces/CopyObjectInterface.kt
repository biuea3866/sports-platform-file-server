package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonFileStorageAccessorRequest

interface CopyObjectInterface {
    fun copyObject(request: CommonFileStorageAccessorRequest)
}