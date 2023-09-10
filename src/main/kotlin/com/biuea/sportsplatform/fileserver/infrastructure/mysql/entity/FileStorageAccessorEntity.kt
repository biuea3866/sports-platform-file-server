package com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity

import com.biuea.sportsplatform.fileserver.domain.enums.FileStorageAccessStatus
import java.time.ZonedDateTime
import javax.persistence.*

@Table(name = "file_storage_accessor")
@Entity
class FileStorageAccessorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "user_id")
    val userId: Long,

    @Column(name = "email")
    val email: String,

    @Column(name = "expiration_date")
    val expirationDate: ZonedDateTime,

    @Column(name = "sdk_key", unique = true)
    val sdkKey: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    val status: FileStorageAccessStatus,

    @Column(name = "create_date")
    val createDate: ZonedDateTime,

    @Column(name = "update_date")
    val updateDate: ZonedDateTime
) {
}