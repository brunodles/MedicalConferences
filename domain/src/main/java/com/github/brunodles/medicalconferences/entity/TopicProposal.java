package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 23/03/16.
 */
public interface TopicProposal extends Entity{
    Conference getConference();

    String getTitle();

    User getSpeaker();
}
