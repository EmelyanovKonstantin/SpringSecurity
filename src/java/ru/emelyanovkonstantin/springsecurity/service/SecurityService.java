package ru.emelyanovkonstantin.springsecurity.service;

/**
 * Service for Security
 *
 * @version 1.0
 */
public interface SecurityService {

    String findLoggetInUsername();

    void autologin(String username, String password);

}
