package org.example.back.repository;

import org.example.back.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    List<Role> findAllByName(String name);
}
