package com.example.service.dto;

import com.example.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListDto implements Dto {

    private long id;
    private String username;
    private String role;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
