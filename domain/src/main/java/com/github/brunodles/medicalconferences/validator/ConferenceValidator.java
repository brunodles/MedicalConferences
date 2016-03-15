package com.github.brunodles.medicalconferences.validator;

import com.github.brunodles.medicalconferences.common.Validator;
import com.github.brunodles.medicalconferences.entity.Conference;

import static com.github.brunodles.medicalconferences.common.StringValidator.isNullOrEmpty;

/**
 * Created by bruno on 14/03/16.
 */
public class ConferenceValidator implements Validator<Conference> {
    @Override
    public boolean isValid(Conference conference) {
        if (isNullOrEmpty(conference.getName())) return false;
        if (isNullOrEmpty(conference.getLocation())) return false;
        if (conference.getContact() == null) return false;
        if (conference.getDate() == null) return false;
        return true;
    }
}
