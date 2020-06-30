package ru.emelyanovkonstantin.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.emelyanovkonstantin.springsecurity.dao.UserDao;
import ru.emelyanovkonstantin.springsecurity.model.Role;
import ru.emelyanovkonstantin.springsecurity.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EmelyanovKonstantin on 30.06.2020
 *
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService} interface.
 *
 * @version 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role: user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
