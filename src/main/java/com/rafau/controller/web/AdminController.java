package com.rafau.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by rafau on 2017-03-19.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin_panel.html";
    }

}