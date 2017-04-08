package com.rafau.config.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by rafau on 2017-04-08.
 */
@Controller
public class AuthenticationController {
    @PostMapping("/login")
    @ResponseBody
    public Principal login(Principal user){
        return user;
    }
}
