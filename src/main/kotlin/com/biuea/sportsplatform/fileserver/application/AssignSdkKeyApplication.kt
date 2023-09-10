package com.biuea.sportsplatform.fileserver.application

import com.biuea.sportsplatform.fileserver.domain.command.AssignSdkKeyCommand
import com.biuea.sportsplatform.fileserver.domain.usecase.AssignSdkKeyUseCase
import com.biuea.sportsplatform.fileserver.interfaces.AssignSdkKeyInterface
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Component
class AssignSdkKeyApplication(
    private val assignSdkKeyUseCase: AssignSdkKeyUseCase
): AssignSdkKeyInterface {
    @Transactional
    override fun assignSdkKey(
        requestUserId: Long,
        requestUserEmail: String,
        expirationDate: ZonedDateTime
    ): String = assignSdkKeyUseCase.execute(
        AssignSdkKeyCommand(
            requestUserId = requestUserId,
            requestUserEmail = requestUserEmail,
            expirationDate = expirationDate
        )
    )
}