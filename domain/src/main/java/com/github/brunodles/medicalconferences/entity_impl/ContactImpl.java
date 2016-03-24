package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Contact;

/**
 * Created by bruno on 14/03/16.
 */
public class ContactImpl implements Contact {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public ContactImpl() {
    }

    public ContactImpl(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getPhone() {
        return phone;
    }
}
