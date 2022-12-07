package com.example.shoppingcartapp_backend.controller;

import com.example.shoppingcartapp_backend.dao.ShoppingcartDao;
import com.example.shoppingcartapp_backend.model.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingcartController {
    @Autowired
    private ShoppingcartDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String AddProducts(@RequestBody Shoppingcart s){
        System.out.println(s.getName().toString());
        System.out.println(s.getImage().toString());
        System.out.println(s.getCategory().toString());
        System.out.println(s.getDescription().toString());
        System.out.println(s.getPrice().toString());
        dao.save(s);

        return "Welcome to product add page";
    }
}
