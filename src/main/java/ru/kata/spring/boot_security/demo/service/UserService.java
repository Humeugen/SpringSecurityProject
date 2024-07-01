package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User findUserById(Long id);

    User findByUsername(String username);

    void editUserById(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();
}
