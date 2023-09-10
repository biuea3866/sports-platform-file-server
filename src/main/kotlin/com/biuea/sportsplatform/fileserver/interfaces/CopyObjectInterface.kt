package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonRequestBuilder

interface CopyObjectInterface {
    fun copyObject(request: CommonRequestBuilder<Unit>)
}