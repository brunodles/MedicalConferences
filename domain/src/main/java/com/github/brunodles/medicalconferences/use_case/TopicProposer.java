package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.TopicProposal;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.LogErrorListener;
import com.github.brunodles.medicalconferences.reposytory.Repository;
import com.github.brunodles.medicalconferences.validator.TopicProposalValidator;

/**
 * Created by bruno on 15/03/16.
 */
public class TopicProposer {
    private final Repository<TopicProposal> topicRepository;
    private final TopicProposalValidator topicProposalValidator;
    private Listener createListener = LogErrorListener.get();

    public TopicProposer(Repository<TopicProposal> topicRepository) {
        this.topicRepository = topicRepository;
        topicProposalValidator = new TopicProposalValidator();
    }

    public boolean propose(Conference conference, String topic) {
        TopicProposal proposal = new TopicProposal(conference, topic);
        if (!topicProposalValidator.isValid(proposal)) return false;

        topicRepository.create(proposal, createListener);
        return true;
    }
}
