package com.example.adapter.`in`.request

import kotlinx.serialization.Serializable
import org.valiktor.functions.hasSize
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isNotEmpty
import org.valiktor.functions.isNotNull
import org.valiktor.validate


@Serializable
data class CreateUser(
    val userId: String?,
    val userPwd: String?,
    val userName: String?
) {
    init {
        validate(this) {
            validate(CreateUser::userId).isNotNull().hasSize(min = 3, max = 20)
            validate(CreateUser::userPwd).isNotNull().isNotEmpty()
            validate(CreateUser::userName).isNotNull().isNotEmpty()
        }
    }
}
