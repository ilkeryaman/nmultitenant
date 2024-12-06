package com.yaman.mtenancy.entity.bat;

import jakarta.persistence.*;

@Entity
@Table(name = "BAT_USER")
public class User {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
