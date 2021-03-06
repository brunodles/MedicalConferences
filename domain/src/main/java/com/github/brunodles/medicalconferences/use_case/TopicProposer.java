package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.TopicProposal;
import com.github.brunodles.medicalconferences.entity.User;
import com.github.brunodles.medicalconferences.entity_impl.TopicProposalImpl;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.LogErrorListener;
import com.github.brunodles.medicalconferences.reposytory.TopicProposalFinder;
import com.github.brunodles.medicalconferences.reposytory.TopicProposalRepository;
import com.github.brunodles.medicalconferences.validator.TopicProposalValidator;

import java.util.List;

/**
 * Created by bruno on 15/03/16.
 */
public class TopicProposer {
    private final TopicProposalRepository topicRepository;
    private final TopicProposalFinder topicFinder;
    private final TopicProposalValidator topicProposalValidator;
    private Listener createListener = LogErrorListener.get();

    public TopicProposer(TopicProposalRepository topicRepository, TopicProposalFinder topicFinder) {
        this.topicRepository = topicRepository;
        this.topicFinder = topicFinder;
        topicProposalValidator = new TopicProposalValidator();
    }

    public boolean propose(Conference conference, String topic, User user) {
        TopicProposal proposal = new TopicProposalImpl(conference, topic, user);
        if (!topicProposalValidator.isValid(proposal)) return false;

        topicRepository.create(proposal, createListener);
        return true;
    }

    public List<TopicProposal> topicsFor(Conference conference) {
        return topicFinder.findBy("conference", conference).list();
    }

    public void setCreateListener(Listener createListener) {
        this.createListener = createListener;
    }
}
