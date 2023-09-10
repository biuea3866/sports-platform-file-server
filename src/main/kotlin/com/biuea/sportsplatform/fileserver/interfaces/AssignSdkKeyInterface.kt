package com.biuea.sportsplatform.fileserver.interfaces

interface AssignSdkKeyInterface {
    fun assignSdkKey(
        requestUserId: Long,
        requestUserEmail: String,
        ex
    ): String
}