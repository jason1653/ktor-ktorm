package com.example.adapter.`in`

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.text.get

fun Route.userRoutes() {
    route("/users") {
        get {
            call.respond(HttpStatusCode.OK, "Hello, users!")
        }
    }
}