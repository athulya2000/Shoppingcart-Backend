package com.example.shoppingcartapp_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingcartController {
    @PostMapping("/add")
    public String AddProducts(){
        return "Welcome to product add page";
    }
}
