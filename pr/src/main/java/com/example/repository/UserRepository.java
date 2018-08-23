package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

import java.util.List;

@Repository/*("userRepository")*/
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findById(int id);
    List<User> findAllById();
}
