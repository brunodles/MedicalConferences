package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 23/03/16.
 */
public interface Invite extends Entity {
    User getUser();

    Conference getConference();

    boolean isAccepted();

    boolean isRejected();
}
