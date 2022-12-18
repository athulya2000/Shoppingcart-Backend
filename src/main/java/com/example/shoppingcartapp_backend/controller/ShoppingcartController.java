package com.example.shoppingcartapp_backend.controller;

import com.example.shoppingcartapp_backend.dao.RegistrationDao;
import com.example.shoppingcartapp_backend.dao.ShoppingcartDao;
import com.example.shoppingcartapp_backend.model.Registration;
import com.example.shoppingcartapp_backend.model.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShoppingcartController {
    @Autowired
    private ShoppingcartDao dao;
    @Autowired
    private RegistrationDao daor;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Map<String, String> AddProducts(@RequestBody Shoppingcart s) {
        System.out.println(s.getName().toString());
        System.out.println(s.getImage().toString());
        System.out.println(s.getCategory().toString());
        System.out.println(s.getDescription().toString());
        System.out.println(s.getPrice().toString());
        dao.save(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Shoppingcart> View() {
        return (List<Shoppingcart>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Shoppingcart> SearchProduct(@RequestBody Shoppingcart s) {
        String name = s.getName();
        System.out.println(name);
        return (List<Shoppingcart>) dao.SearchProduct(s.getName());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
    public Map<String, String> Registration(@RequestBody Registration r) {
        System.out.println(r.getName().toString());
        System.out.println(r.getAddress().toString());
        System.out.println(r.getPhoneno().toString());
        System.out.println(r.getEmailid().toString());
        System.out.println(r.getPassword().toString());
        System.out.println(r.getConfirmpassword().toString());
        daor.save(r);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/validitity", consumes = "application/json", produces = "application/json")
    public Map<String, String> Validation(@RequestBody Registration r) {
        String emailid = r.getEmailid();
        String password = r.getPassword();
        System.out.println(emailid);
        System.out.println(password);
        List<Registration> result = (List<Registration>) daor.Validation(r.getEmailid(), r.getPassword());
        HashMap<String, String> st = new HashMap<>();
        if (result.size() == 0) {
            st.put("status", "failed");
            st.put("message", "user doesnt exist");

        } else {
            int id = result.get(0).getId();
            st.put("userId", String.valueOf(id));
            st.put("status", "success");
            st.put("message", "user login success");

        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userinfo", consumes = "application/json", produces = "application/json")
    public List<Registration> Userinfo(@RequestBody Registration r) {
        String id = String.valueOf(r.getId());
        System.out.println(id);
        return (List <Registration>) daor.ViewProfile(r.getId());

    }
}
