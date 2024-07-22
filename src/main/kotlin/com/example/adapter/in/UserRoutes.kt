package com.example.adapter.`in`

import com.example.adapter.`in`.request.CreateUser
import com.example.adapter.`in`.request.validateCreateUser
import com.example.response.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.SerializationException
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.hasSize
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isNotNull
import org.valiktor.validate


fun Route.userRoutes() {
    route("/users") {
        get {
            call.respond(HttpStatusCode.OK, "Hello, users!")
        }

        post {

            val createUser = call.receive<CreateUser>()
            validateCreateUser(createUser)
            call.respond(HttpStatusCode.Created, createUser)



        }
    }

}
