package com.taaviansper.petmanagementapi.service;

import com.taaviansper.petmanagementapi.model.UserModel;
import com.taaviansper.petmanagementapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;

    public Optional<UserModel> findUserByName(String name) {
        return ur.findByName(name);
    }
}
