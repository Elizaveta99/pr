package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "auth_users")
public class AuthUser {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column
    @JsonIgnore  /*???*/
    private String password;
}
