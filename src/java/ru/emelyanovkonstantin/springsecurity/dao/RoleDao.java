package ru.emelyanovkonstantin.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.emelyanovkonstantin.springsecurity.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
