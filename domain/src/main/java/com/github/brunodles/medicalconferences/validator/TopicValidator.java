package com.github.brunodles.medicalconferences.validator;

import com.github.brunodles.medicalconferences.common.Validator;
import com.github.brunodles.medicalconferences.entity.Topic;

import static com.github.brunodles.medicalconferences.common.StringValidator.isNullOrEmpty;

/**
 * Created by bruno on 23/03/16.
 */
public class TopicValidator implements Validator<Topic> {
    @Override
    public boolean isValid(Topic topic) {
        if (isNullOrEmpty(topic.getTitle())) return false;
        if (topic.getSpeaker() == null) return false;
        return true;
    }
}
