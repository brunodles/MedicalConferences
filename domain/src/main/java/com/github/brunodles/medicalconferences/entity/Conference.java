package com.github.brunodles.medicalconferences.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 23/03/16.
 */
public interface Conference extends Entity {

    Date getDate();

    String getName();

    String getAbstract();

    String getLocation();

    Contact getContact();

    List<Topic> getTopics();

    boolean isCanceled();
}
