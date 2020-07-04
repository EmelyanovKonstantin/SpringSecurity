package ru.emelyanovkonstantin.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.emelyanovkonstantin.springsecurity.dao.RoleDao;
import ru.emelyanovkonstantin.springsecurity.dao.UserDao;
import ru.emelyanovkonstantin.springsecurity.model.Role;
import ru.emelyanovkonstantin.springsecurity.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EmelyanovKonstantin on 30.06.2020
 *
 * Implementation of {@link UserService} interface
 *
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private RoleDao roleDao;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
