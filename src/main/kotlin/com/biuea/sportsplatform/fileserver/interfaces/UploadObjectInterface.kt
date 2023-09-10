package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonFileStorageAccessorRequest
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

interface UploadObjectInterface {
    fun uploadObject(
        builder: CommonFileStorageAccessorRequest,
        inputStream: InputStream,
        size: Long
    )

    fun uploadObject(
        request: CommonFileStorageAccessorRequest,
        multipartFile: MultipartFile
    )

    fun uploadObject(
        request: CommonFileStorageAccessorRequest,
        file: File
    )

    fun uploadObject(
        request: CommonFileStorageAccessorRequest,
        byteArray: ByteArray
    )
}