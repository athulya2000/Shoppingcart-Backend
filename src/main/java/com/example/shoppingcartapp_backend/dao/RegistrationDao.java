package com.example.shoppingcartapp_backend.dao;

import com.example.shoppingcartapp_backend.model.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationDao extends CrudRepository<Registration,Integer> {
}
