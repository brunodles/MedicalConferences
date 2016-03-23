package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.User;

/**
 * Created by bruno on 14/03/16.
 */
public class UserImpl implements User {

    private Long id;
    private String name;
    private String login;
    private String password;
    private boolean admin;

    public UserImpl() {
    }

    public UserImpl(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.admin = user.isAdmin();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
