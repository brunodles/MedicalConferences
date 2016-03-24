package com.github.brunodles.medicalconferences.repositories;

import android.support.annotation.NonNull;

import com.github.brunodles.medicalconferences.entity.Contact;
import com.github.brunodles.medicalconferences.repositories.dtos.ContactRecord;

/**
 * Created by bruno on 15/03/16.
 */
public class ContactRepository extends BaseRepository<
        Contact, ContactRecord> {

    @NonNull
    @Override
    ContactRecord parse(Contact obj) {
        return new ContactRecord(obj);
    }
}
