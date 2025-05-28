package com.gowtham.ecom.ecom_app.services;

import com.gowtham.ecom.ecom_app.models.Users;
import com.gowtham.ecom.ecom_app.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }


    public List<Users> getUsers(){
        return userRepo.findAll();
    }
}
