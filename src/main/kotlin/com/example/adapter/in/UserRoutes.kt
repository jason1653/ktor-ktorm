package com.example.adapter.`in`

import com.example.adapter.`in`.request.CreateUser
import com.example.response.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.valiktor.ConstraintViolationException


fun Route.userRoutes() {
    accept(ContentType.Application.Json) {
        route("/users") {
            get {
                call.respond(HttpStatusCode.OK, "Hello, users!")
            }

            post {

                try {
                    val createUser = call.receive<CreateUser>()
                    call.respond(HttpStatusCode.Created, createUser)

                } catch(e: ConstraintViolationException) {
                    val errorResponse = ErrorResponse(
                        status = HttpStatusCode.BadRequest.value,
                        message = e.constraintViolations.joinToString(", ") { "${it.property}: ${it.constraint.name}" }
                    )
                    call.respond(HttpStatusCode.BadRequest, errorResponse)
                }


            }
        }
    }

}
