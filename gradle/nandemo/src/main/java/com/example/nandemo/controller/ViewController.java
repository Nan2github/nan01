package com.example.nandemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/view-products")
    public String viewProducts(){
        return "view_products";
    }

    @RequestMapping("/add-products")
    public String addProducts(){
        return "add_products";
    }

    @RequestMapping("/locale")
    public String locale(){
        return "locale";
    }
}
