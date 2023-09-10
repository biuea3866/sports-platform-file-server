package com.biuea.sportsplatform.fileserver.infrastructure.mysql.entity

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "file_storage")
class FileStorageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "file_name")
    val filename: String,
    @Column(name = "extension")
    val extension: String,
    @Column(name = "size")
    val size: Long,
    @Column(name = "absolute_path")
    val absolutePath: String,
    @Column(name = "uploader_id")
    val uploaderId: Long,
    @Column(name = "create_date")
    val createDate: ZonedDateTime,
    @Column(name = "update_date")
    val updateDate: ZonedDateTime
) {
}