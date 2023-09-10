package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonRequestBuilder
import java.io.InputStream

interface FileServerAccessClient: UploadObjectInterface {
    fun renameObject(request: CommonRequestBuilder)
    fun deleteObject(request: CommonRequestBuilder)
    fun checkIfExistObject(request: CommonRequestBuilder): Boolean
    fun getObjectStream(request: CommonRequestBuilder): InputStream
    fun getObjectUrl(request: CommonRequestBuilder)
}