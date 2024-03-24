package ru.bogatyryov.springbootapp.service;

import ru.bogatyryov.springbootapp.model.User;

import java.util.List;

public interface UserService {

    void add(User user);
    List<User> listUsers();

    void delete(long id);

    void update(User user);
    User findById(long id);

}
