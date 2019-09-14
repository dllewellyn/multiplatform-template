package server

import com.auto.synch.core.helloWorldLogic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloWorldController {

    @Get("hello")
    fun hello() = helloWorldLogic()
}gi