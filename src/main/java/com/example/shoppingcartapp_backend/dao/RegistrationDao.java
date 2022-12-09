package com.example.shoppingcartapp_backend.dao;

import com.example.shoppingcartapp_backend.model.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationDao extends CrudRepository<Registration,Integer> {
    @Query(value="SELECT `id`, `address`, `confirmpassword`, `emailid`, `name`, `password`, `phoneno` FROM `registration` WHERE `emailid`= :emailid AND `password`= :password",nativeQuery = true)
    List<Registration> Validation(@Param("emailid") String emailid,@Param("password") String password);
}
