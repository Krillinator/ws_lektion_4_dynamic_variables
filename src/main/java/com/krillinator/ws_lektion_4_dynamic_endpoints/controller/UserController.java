package com.krillinator.ws_lektion_4_dynamic_endpoints.controller;

import com.krillinator.ws_lektion_4_dynamic_endpoints.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// RequestMapping - Class & Method Level
// GetMapping - Method Level
// Resource (/user) - Endpoint
@RestController
@RequestMapping("/user")
public class UserController {

    private final List<User> userList = new ArrayList<>(
            List.of(
                    new User(0 ,"Benny", "123"),
                    new User(1, "Frida", "456")
            )
    );

    @GetMapping
    public List<User> getUsers() {

        return userList;
    }

    @PostMapping("/{username}")
    public boolean postUser(@PathVariable("username") String username) {

        return userList.add(
                new User(userList.size(), username, "1337")
        );
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable("id") int id) {

        for (User user : userList) {
            if (user.id() == id) {
                return userList.remove(id);
            }
        }

        return null;
    }

}
