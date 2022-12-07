package com.example.shoppingcartapp_backend.dao;

import com.example.shoppingcartapp_backend.model.Shoppingcart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingcartDao extends CrudRepository<Shoppingcart,Integer> {
}
