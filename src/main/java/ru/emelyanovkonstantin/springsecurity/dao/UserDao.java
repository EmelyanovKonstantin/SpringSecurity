package ru.emelyanovkonstantin.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.emelyanovkonstantin.springsecurity.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
