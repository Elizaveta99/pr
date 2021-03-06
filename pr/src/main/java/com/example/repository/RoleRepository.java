package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByRole(String role);
}
