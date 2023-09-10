package com.biuea.sportsplatform.fileserver.application

import com.biuea.sportsplatform.fileserver.domain.command.UploadInputStreamCommand
import com.biuea.sportsplatform.fileserver.domain.factory.UploadObjectFactory
import com.biuea.sportsplatform.fileserver.domain.service.CheckSdkValidationService
import com.biuea.sportsplatform.fileserver.interfaces.UploadObjectInterface
import com.biuea.sportsplatform.fileserver.interfaces.request.CommonFileStorageAccessorRequest
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.InputStream

@Component
class UploadObjectApplication(
    private val checkSdkValidationService: CheckSdkValidationService,
    private val uploadObjectFactory: UploadObjectFactory
): UploadObjectInterface {
    override fun uploadObject(
        request: CommonFileStorageAccessorRequest,
        multipartFile: MultipartFile
    ) {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun uploadObject(
        // request로 이름 바꾸기
        builder: CommonFileStorageAccessorRequest,
        inputStream: InputStream,
        size: Long
    ) {
        val accessor = checkSdkValidationService.execute(builder.sdkKey)
        uploadObjectFactory.getUseCase(UploadInputStreamCommand::class.java)
            .execute(UploadInputStreamCommand(
                builder = builder,
                inputStream = inputStream,
                accessor = accessor,
                size = size
            ))
    }

    override fun uploadObject(
        request: CommonFileStorageAccessorRequest,
        file: File
    ) {
        TODO("Not yet implemented")
    }

    override fun uploadObject(
        request: CommonFileStorageAccessorRequest,
        byteArray: ByteArray
    ) {
        TODO("Not yet implemented")
    }
}