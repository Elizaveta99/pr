package com.example.service;

import com.example.model.UserRole;
import com.example.service.dto.UserListDto;
import com.example.service.transformer.UserListTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User findUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user)
    {
         user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // Role userRole = roleRepository.findByRole("ADMIN");
        // user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }

    @Autowired
    private UserListTransformer userListTransformer;

    @Transactional(readOnly = true)
    public List<UserListDto> findAll() {
        Iterable<User> users = userRepository.findAll();

        List<UserListDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserListDto dto = this.userListTransformer.makeDto(user);
            userDtoList.add(dto);
        }

        return userDtoList;
    }

}
