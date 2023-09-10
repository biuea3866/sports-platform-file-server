package com.biuea.sportsplatform.fileserver.domain.usecase

import com.biuea.sportsplatform.fileserver.domain.command.UploadObjectBaseCommand

interface UploadObjectUseCase<C: UploadObjectBaseCommand> {
    fun getCommandType(): Class<C>
    fun execute(command: C)
}