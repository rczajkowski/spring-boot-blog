package com.rafau.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by rafau on 2017-03-16.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }
}
