package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.TopicProposal;
import com.github.brunodles.medicalconferences.entity.User;

/**
 * Created by bruno on 15/03/16.
 */
public class TopicProposalImpl implements TopicProposal {
    private Long id;
    private final Conference conference;
    private final String topic;
    private final User speaker;

    public TopicProposalImpl(Conference conference, String topic, User speaker) {
        this.conference = conference;
        this.topic = topic;
        this.speaker = speaker;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Conference getConference() {
        return conference;
    }

    @Override
    public String getTitle() {
        return topic;
    }

    @Override
    public User getSpeaker() {
        return speaker;
    }
}
