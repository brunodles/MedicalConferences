package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 14/03/16.
 */
public class Contact {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
