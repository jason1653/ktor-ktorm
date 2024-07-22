package com.example.response

import kotlinx.serialization.Serializable


@Serializable
data class ErrorResponse(
    val status: Int,
    val message: String
) {
}