package com.github.brunodles.medicalconferences.validator;

import com.github.brunodles.medicalconferences.common.Validator;
import com.github.brunodles.medicalconferences.entity.Contact;

import static com.github.brunodles.medicalconferences.common.StringValidator.isNullOrEmpty;

/**
 * Created by bruno on 14/03/16.
 */
public class ContactValidator implements Validator<Contact> {
    @Override
    public boolean isValid(Contact contact) {
        if (isNullOrEmpty(contact.getName())) return false;
        String phone = contact.getPhone();
        String email = contact.getEmail();

        if (phone == null && email == null) return false;

        if (phone != null && phone.isEmpty()) return false;
        if (email != null && email.isEmpty()) return false;

        return true;
    }
}
