package server

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloWorldController {

    @Get("hello")
    fun hello() = "Hello world"
}