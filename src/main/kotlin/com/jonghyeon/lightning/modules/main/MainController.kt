package com.jonghyeon.lightning.modules.main

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/")
    fun home(): String {
        return "index"
    }

}