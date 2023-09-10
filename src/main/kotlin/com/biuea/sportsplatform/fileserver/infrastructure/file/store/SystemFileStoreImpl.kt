package com.biuea.sportsplatform.fileserver.infrastructure.file.store

import com.biuea.sportsplatform.fileserver.domain.store.ImageFileStore
import com.biuea.sportsplatform.fileserver.domain.store.PdfFileStore
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import javax.imageio.ImageIO

@Component
class SystemFileStoreImpl: ImageFileStore, PdfFileStore {
    override fun writeImage(
        inputStream: InputStream,
        size: Long,
        basePath: String,
        key: String,
        extension: String
    ) {
        val file = File("$basePath$key.$extension")
        val bufferedImage = ImageIO.read(file)

        try {
            ImageIO.write(bufferedImage, extension, file)
        } catch(e: IOException) {
            throw e
        }
    }

    override fun writePdf(
        inputStream: InputStream,
        size: Long,
        basePath: String,
        key: String,
        extension: String
    ) {
        try {
            val outputStream = FileOutputStream("$basePath$key.$extension")
            val buffer = ByteArray(size.toInt())
            var read: Int

            while (inputStream.read(buffer).also { read = it} != -1) outputStream.write(buffer, 0, read)

            inputStream.close()
            outputStream.close()
        } catch(e: IOException) {
            throw e
        }
    }
}