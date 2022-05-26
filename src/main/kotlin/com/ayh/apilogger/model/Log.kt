package com.ayh.apilogger.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "logs")
data class Log(
        @Id
        var id: String? = ObjectId().toHexString(),
        var type: String,
        val data: String,
        val source: String,
        val timestamp: LocalDateTime = LocalDateTime.now()
)
