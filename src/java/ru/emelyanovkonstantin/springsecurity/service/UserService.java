package ru.emelyanovkonstantin.springsecurity.service;

import ru.emelyanovkonstantin.springsecurity.model.User;

/**
 * Service class for {@link ru.emelyanovkonstantin.springsecurity.model.User}
 *
 * @version 1.0
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
