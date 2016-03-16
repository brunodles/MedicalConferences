package com.github.brunodles.medicalconferences.repositories;

import android.support.annotation.NonNull;

import com.github.brunodles.medicalconferences.entity.Contact;

/**
 * Created by bruno on 15/03/16.
 */
public class ContactRepository extends BaseRepository<
        Contact, com.github.brunodles.medicalconferences.repositories.dtos.Contact> {

    @NonNull
    @Override
    com.github.brunodles.medicalconferences.repositories.dtos.Contact parse(Contact obj) {
        return new com.github.brunodles.medicalconferences.repositories.dtos.Contact(obj);
    }
}
