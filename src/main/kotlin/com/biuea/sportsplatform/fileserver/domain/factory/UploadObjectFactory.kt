package com.biuea.sportsplatform.fileserver.domain.factory

import com.biuea.sportsplatform.fileserver.domain.command.UploadObjectBaseCommand
import com.biuea.sportsplatform.fileserver.domain.usecase.UploadObjectUseCase
import org.springframework.stereotype.Component

@Component
class UploadObjectFactory(
    val useCases: Set<UploadObjectUseCase<UploadObjectBaseCommand>>
) {
    fun<C: UploadObjectBaseCommand> getUseCase(type: Class<C>) =
        this.useCases.find { it.getCommandType() == type }?: throw IllegalArgumentException("no such use case")
}