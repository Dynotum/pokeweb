package com.csedano.pokeweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/algo")
    public String sayHello(
            @RequestParam(defaultValue = "World", required = false) String algo, Model model) {
        model.addAttribute("algo", algo);
        return "hello";
    }
}
