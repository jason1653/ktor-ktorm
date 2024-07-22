package com.example.plugins

import com.example.response.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import kotlinx.serialization.SerializationException
import org.valiktor.ConstraintViolationException


fun Application.configureValidation() {
    install(RequestValidation)

    install(StatusPages) {

        exception<ConstraintViolationException> { call, cause ->
            val errorResponse = ErrorResponse(
                status = HttpStatusCode.BadRequest.value,
                message = cause.constraintViolations.joinToString(", ") { "${it.property}: ${it.constraint.name}" }
            )
            call.respond(HttpStatusCode.BadRequest, errorResponse)
        }

        exception<SerializationException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, "Invalid JSON format: ${cause.localizedMessage}")
        }

        exception<RequestValidationException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, cause.reasons.joinToString())
        }
    }

}