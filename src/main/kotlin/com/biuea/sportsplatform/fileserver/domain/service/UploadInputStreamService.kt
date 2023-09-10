package com.biuea.sportsplatform.fileserver.domain.service

import com.biuea.sportsplatform.fileserver.domain.command.UploadInputStreamCommand
import com.biuea.sportsplatform.fileserver.domain.model.FileStorage
import com.biuea.sportsplatform.fileserver.domain.store.FileStorageStore
import com.biuea.sportsplatform.fileserver.domain.store.ImageFileStore
import com.biuea.sportsplatform.fileserver.domain.store.PdfFileStore
import com.biuea.sportsplatform.fileserver.domain.usecase.UploadObjectUseCase
import com.biuea.sportsplatform.fileserver.domain.utils.FileUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class UploadInputStreamService(
    @Value("\${storage.base-path}")
    private val basePath: String,
    private val fileStorageStore: FileStorageStore,
    private val pdfFileStore: PdfFileStore,
    private val imageFileStore: ImageFileStore
): UploadObjectUseCase<UploadInputStreamCommand> {
    override fun getCommandType(): Class<UploadInputStreamCommand> = UploadInputStreamCommand::class.java

    override fun execute(command: UploadInputStreamCommand) {
        val fileStorage = fileStorageStore.save(FileStorage.create(
            key = command.builder.key,
            size = command.size,
            uploadId = command.accessor.userId,
            basePath = basePath
        ))
        fileStorageStore.save(fileStorage)
        when (FileUtils.extractExtension(command.builder.key)) {
            "pdf" -> pdfFileStore.writePdf(
                inputStream = command.inputStream,
                size = command.size,
                basePath = basePath,
                key = command.builder.key,
                extension = FileUtils.extractExtension(command.builder.key)
            )
            "jpeg, png, jpg" -> imageFileStore.writeImage(
                inputStream = command.inputStream,
                size = command.size,
                basePath = basePath,
                key = command.builder.key,
                extension = FileUtils.extractExtension(command.builder.key)
            )
            else -> throw IllegalArgumentException("지원하지 않는 파일 형식입니다.")
        }
    }
}