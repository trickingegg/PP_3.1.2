package ru.bogatyryov.springbootapp.dao;

import ru.bogatyryov.springbootapp.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> listUsers();
    void delete(long id);
    void update(User user);
    User findById(long id);

}
