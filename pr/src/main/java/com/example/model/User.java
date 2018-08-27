package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "pr_users")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String password, final UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void applyChanges(final User inUser) {
        this.setUsername(inUser.getUsername());
        this.setRole(inUser.getRole());
        this.setPassword(inUser.getPassword());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
