package cat.little

import cat.little.plugins.configureRouting
import cat.little.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8088, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}