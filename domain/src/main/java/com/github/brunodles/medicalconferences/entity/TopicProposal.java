package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 15/03/16.
 */
public class TopicProposal {
    private final Conference conference;
    private final String topic;
    private final User speaker;

    public TopicProposal(Conference conference, String topic, User speaker) {
        this.conference = conference;
        this.topic = topic;
        this.speaker = speaker;
    }

    public Conference getConference() {
        return conference;
    }

    public String getTopic() {
        return topic;
    }

    public User getSpeaker() {
        return speaker;
    }
}
