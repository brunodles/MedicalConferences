package com.github.brunodles.medicalconferences.repositories.dtos;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by bruno on 16/03/16.
 */
@Table(name = "Temp")
public class Temp extends Model {
    @Column(name = "name")
    public String name;
}