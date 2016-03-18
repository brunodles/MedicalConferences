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
public class Contact extends Model {
    @Column(name = COLUMN_ID)
    public Long id;
    @Column(name = COLUMN_NAME)
    public String name;
    @Column(name = COLUMN_EMAIL)
    public String email;
    @Column(name = COLUMN_PHONE)
    public String phone;

    public Contact() {
        super();
    }

    public Contact(com.github.brunodles.medicalconferences.entity.Contact contact) {
        super();
        this.id = contact.getId();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }

    public com.github.brunodles.medicalconferences.entity.Contact toContact() {
        com.github.brunodles.medicalconferences.entity.Contact contact = new com.github.brunodles.medicalconferences.entity.Contact();
        contact.setId(this.id);
        contact.setName(this.name);
        contact.setEmail(this.email);
        contact.setPhone(this.phone);
        return contact;
    }
}
