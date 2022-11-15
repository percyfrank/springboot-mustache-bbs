package com.mustache.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MustacheController {

    @GetMapping(value = "/hi")
    public String mustacheCon(Model model) {
        model.addAttribute("username", "권오석"); // view에 값을 넘김
        return "welcome/greetings"; // greetings view 리턴
    }

    @GetMapping(value = "/hi/{id}")
    public String mustacheCon2(@PathVariable String id, Model model) {
        model.addAttribute("username", "권오석"); // view에 값을 넘김
        model.addAttribute("id", id); // view에 값을 넘김
        return "welcome/greetings"; // greetings view 리턴
    }

    @GetMapping(value = "/bye")
    public String mustacheCon3(Model model) {
        model.addAttribute("username", "권오석"); // view에 값을 넘김
        return "welcome/goodbye";
    }

}
