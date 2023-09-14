package com.biuea.sportsplatform.fileserver.interfaces

import com.biuea.sportsplatform.fileserver.common.response.CommonResponse
import com.biuea.sportsplatform.fileserver.interfaces.request.AssignSdkKeyRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController("/file")
class FileAccessorController(
    private val assignSdkKeyInterface: AssignSdkKeyInterface
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping(
        value = ["/sdk/assign"],
        produces = ["application/json; charset=utf-8"],
    )
    fun assignSdkKey(
        @RequestBody @Valid request: AssignSdkKeyRequest
    ): CommonResponse<String> {
        logger.info("assignSdkKey - request: {}", request)

        return CommonResponse.success(
            code = HttpStatus.CREATED,
            data = assignSdkKeyInterface.assignSdkKey(
                requestUserId = request.requestUserId,
                requestUserEmail = request.requestUserEmail,
                expirationDate = request.expirationDate
            )
        )
    }
}