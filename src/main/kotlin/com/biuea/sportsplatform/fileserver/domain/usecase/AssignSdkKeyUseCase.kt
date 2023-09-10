package com.biuea.sportsplatform.fileserver.domain.usecase

import com.biuea.sportsplatform.fileserver.domain.command.AssignSdkKeyCommand

interface AssignSdkKeyUseCase {
    fun execute(command: AssignSdkKeyCommand): String
}