package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 15/03/16.
 */
public class TopicProposal {
    private final Conference conference;
    private final String topic;

    public TopicProposal(Conference conference, String topic) {
        this.conference = conference;
        this.topic = topic;
    }

    public Conference getConference() {
        return conference;
    }

    public String getTopic() {
        return topic;
    }
}
