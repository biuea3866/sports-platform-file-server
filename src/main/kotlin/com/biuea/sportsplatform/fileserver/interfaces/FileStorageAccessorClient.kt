package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonFileStorageAccessorRequest
import java.io.InputStream

interface FileStorageAccessorClient:
    UploadObjectInterface,
    AssignSdkKeyInterface
{
    fun renameObject(request: CommonFileStorageAccessorRequest)
    fun deleteObject(request: CommonFileStorageAccessorRequest)
    fun checkIfExistObject(request: CommonFileStorageAccessorRequest): Boolean
    fun getObjectStream(request: CommonFileStorageAccessorRequest): InputStream
    fun getObjectUrl(request: CommonFileStorageAccessorRequest)
}