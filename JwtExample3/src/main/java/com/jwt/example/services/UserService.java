package com.jwt.example.services;

import com.jwt.example.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User("101","Varun","varun@gmail.com"));
        store.add(new User("102","Atheeq","atheeq@gmail.com"));
        store.add(new User("103","Raghav","raghav@gmail.com"));
        store.add(new User("104","Rakesh","rakesh@gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }
}
