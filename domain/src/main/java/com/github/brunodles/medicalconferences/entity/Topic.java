package com.github.brunodles.medicalconferences.entity;

/**
 * Created by bruno on 23/03/16.
 */
public interface Topic extends Entity {

    String getTitle();

    User getSpeaker();
}
