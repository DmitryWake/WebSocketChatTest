package com.example.websocketchattest.api.request

import com.example.websocketchattest.api.model.MessageModel

data class PublishRequest(
    val channel: String,
    val data: String
)