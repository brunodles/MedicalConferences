package com.github.brunodles.medicalconferences.repositories.dtos;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import static com.github.brunodles.medicalconferences.repositories.tables.ContactTable.COLUMN_EMAIL;
import static com.github.brunodles.medicalconferences.repositories.tables.ContactTable.COLUMN_ID;
import static com.github.brunodles.medicalconferences.repositories.tables.ContactTable.COLUMN_NAME;
import static com.github.brunodles.medicalconferences.repositories.tables.ContactTable.COLUMN_PHONE;
import static com.github.brunodles.medicalconferences.repositories.tables.ContactTable.TABLE;

/**
 * Created by bruno on 15/03/16.
 */
@Table(name = TABLE)
public class ContactRecord extends Model implements com.github.brunodles.medicalconferences.entity.Contact{
    @Column(name = COLUMN_ID)
    private Long id;
    @Column(name = COLUMN_NAME)
    private String name;
    @Column(name = COLUMN_EMAIL)
    private String email;
    @Column(name = COLUMN_PHONE)
    private String phone;

    public ContactRecord() {
        super();
    }

    public ContactRecord(com.github.brunodles.medicalconferences.entity.Contact contactImpl) {
        super();
        this.id = contactImpl.getId();
        this.name = contactImpl.getName();
        this.email = contactImpl.getEmail();
        this.phone = contactImpl.getPhone();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
