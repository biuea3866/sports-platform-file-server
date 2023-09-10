package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.interfaces.request.CommonRequestBuilder
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

interface UploadObjectInterface {
    fun<I: InputStream> uploadObject(
        builder: CommonRequestBuilder,
        inputStream: I,
        size: Long
    )

    fun<M: MultipartFile> uploadObject(
        request: CommonRequestBuilder,
        multipartFile: M
    )

    fun<F: File> uploadObject(
        request: CommonRequestBuilder,
        file: F
    )
}