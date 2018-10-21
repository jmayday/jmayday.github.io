package com.pgssoftware.service;

import com.pgssoftware.model.User;

public class UserRepository {

    public User findById(long id) throws Exception {
        if (id != 1001) {
            return User.builder().id(id).build();
        }
        else {
            throw new Exception("User with id " + id + " not found");
        }
    }

}
