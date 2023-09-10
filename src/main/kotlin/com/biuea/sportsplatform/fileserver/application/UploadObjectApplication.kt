package com.biuea.sportsplatform.fileserver.application

import com.biuea.sportsplatform.fileserver.domain.command.UploadInputStreamCommand
import com.biuea.sportsplatform.fileserver.domain.factory.UploadObjectFactory
import com.biuea.sportsplatform.fileserver.domain.service.CheckSdkValidationService
import com.biuea.sportsplatform.fileserver.interfaces.UploadObjectInterface
import com.biuea.sportsplatform.fileserver.interfaces.request.CommonRequestBuilder
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

@Component
class UploadObjectApplication(
    private val checkSdkValidationService: CheckSdkValidationService,
    private val uploadObjectFactory: UploadObjectFactory
): UploadObjectInterface {
    override fun <F : File> uploadObject(request: CommonRequestBuilder, file: F) {
        TODO("Not yet implemented")
    }

    override fun <I : InputStream> uploadObject(builder: CommonRequestBuilder, inputStream: I, size: Long) {
        val accessor = checkSdkValidationService.execute(builder.sdkKey)
        uploadObjectFactory.getUseCase(UploadInputStreamCommand::class.java)
            .execute(UploadInputStreamCommand(
                builder = builder,
                inputStream = inputStream,
                accessor = accessor,
                size = size
            ))
    }

    override fun <M : MultipartFile> uploadObject(request: CommonRequestBuilder, multipartFile: M) {
        TODO("Not yet implemented")
    }
}