package com.example.shoppingcartapp_backend.dao;

import com.example.shoppingcartapp_backend.model.Shoppingcart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingcartDao extends CrudRepository<Shoppingcart,Integer> {
    @Query(value="SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `products` WHERE `name`=:name",nativeQuery = true)
    List<Shoppingcart> SearchProduct(@Param("name") String name);
}
