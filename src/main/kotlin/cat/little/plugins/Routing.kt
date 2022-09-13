package cat.little.plugins

import cat.little.routes.randomCat
import cat.little.routes.specialCat
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        randomCat()
        specialCat()
        static {
            resources("static")
        }
    }
}
