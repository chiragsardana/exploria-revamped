package com.devnologix.exploria_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping()
    @ResponseBody
    public String homePage(){
        return "<h1><center>Welcome to Resturant Backend</center></h1>";
    }
}
// https://resturant-backend-sbk.herokuapp.com/
