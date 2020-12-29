package com.example.websocketchattest.api.model

data class ChannelModel(
    val created_at: String,
    val listeners: ArrayList<String>?,
    val listeners_count: Int,
    val name: String,
    val subscribers: ArrayList<String>?,
    val subscribers_count: Int,
    val type: String,
    val updated_at: String
)