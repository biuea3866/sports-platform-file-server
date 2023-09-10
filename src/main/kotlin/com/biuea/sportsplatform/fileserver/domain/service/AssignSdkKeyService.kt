package com.biuea.sportsplatform.fileserver.domain.service

import com.biuea.sportsplatform.fileserver.domain.command.AssignSdkKeyCommand
import com.biuea.sportsplatform.fileserver.domain.store.FileStorageAccessorStore
import com.biuea.sportsplatform.fileserver.domain.usecase.AssignSdkKeyUseCase
import org.springframework.stereotype.Service

@Service
class AssignSdkKeyService(
    private val fileStorageAccessorStore: FileStorageAccessorStore
): AssignSdkKeyUseCase {
    override fun execute(command: AssignSdkKeyCommand): String {
        return fileStorageAccessorStore.save(command.toModel()).sdkKey
    }
}