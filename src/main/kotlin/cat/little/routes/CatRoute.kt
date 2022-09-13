package cat.little.routes

import cat.little.data.model.Cat
import cat.little.data.model.SpecialCatRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//本地IPV4地址
private const val BASE_URL = "http://192.168.31.229:8088"

private val cats = listOf(
    Cat("夺宝1号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat1.jpg"),
    Cat("夺宝2号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat2.jpg"),
    Cat("夺宝3号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat3.jpg"),
    Cat("夺宝4号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat4.jpg"),
    Cat("夺宝5号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat5.jpg"),
    Cat("夺宝6号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat6.jpg"),
    Cat("夺宝7号", "这是一只可爱的小猫咪", "$BASE_URL/cats/cat7.jpg"),
)

fun Route.randomCat() {
    get("/random-cat") {
        call.respond(cats.random())
    }
}

fun Route.specialCat() {
    post("/special-cat") {
        val request = call.receive<SpecialCatRequest>()
        val catNumber = request.number
        if (catNumber in 1..7) {
            call.respond(HttpStatusCode.OK, cats[catNumber - 1])
        } else {
            call.respond(HttpStatusCode.BadRequest)
        }
    }
}