package com.github.brunodles.medicalconferences.validator;

import com.github.brunodles.medicalconferences.common.Validator;
import com.github.brunodles.medicalconferences.entity.TopicProposal;

import static com.github.brunodles.medicalconferences.common.StringValidator.isNullOrEmpty;

/**
 * Created by bruno on 15/03/16.
 */
public class TopicProposalValidator implements Validator<TopicProposal> {

    @Override
    public boolean isValid(TopicProposal topicProposal) {
        if (topicProposal.getConference() == null) return false;
        if (isNullOrEmpty(topicProposal.getTopic())) return false;
        return true;
    }
}
