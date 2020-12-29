package com.example.websocketchattest.api

data class ChannelRequest (
    val name: String,
    val type: String = "public"
)