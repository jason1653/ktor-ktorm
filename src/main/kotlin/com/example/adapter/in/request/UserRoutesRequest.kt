package com.example.adapter.`in`.request

import kotlinx.serialization.Serializable
import org.valiktor.functions.*
import org.valiktor.validate


@Serializable
data class CreateUser(
    val userId: String = "",
    val userPwd: String = "",
    val userName: String = ""
)


fun validateCreateUser(createUser: CreateUser) {
    validate(createUser) {
        validate(CreateUser::userId).isNotNull().isNotBlank().hasSize(min = 3, max = 50)
        validate(CreateUser::userPwd).isNotNull().isNotBlank().hasSize(min = 3, max = 50)
        validate(CreateUser::userName).isNotNull().isNotBlank().hasSize(min = 3, max = 50)
    }
}