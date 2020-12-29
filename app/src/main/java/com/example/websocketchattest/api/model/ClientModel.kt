package com.example.websocketchattest.api.model

data class ClientModel (
    val channels: ArrayList<String>,
    val created_at: String,
    val id: String,
    val token: String,
    val updated_at: String
)