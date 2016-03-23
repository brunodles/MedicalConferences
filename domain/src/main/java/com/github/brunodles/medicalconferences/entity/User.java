package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 23/03/16.
 */
public interface User extends Entity{
    String getName();

    String getLogin();

    String getPassword();

    boolean isAdmin();
}
