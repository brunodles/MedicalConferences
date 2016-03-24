package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.Contact;
import com.github.brunodles.medicalconferences.entity.Topic;
import com.github.brunodles.medicalconferences.validator.TopicValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 14/03/16.
 */
public class ConferenceImpl implements Conference {

    private Long id;
    private Date date;
    private String name;
    private String anAbstract;
    private String location;
    private Contact contact;
    private List<Topic> topics;
    private boolean canceled;

    private final TopicValidator topicValidator = new TopicValidator();

    public ConferenceImpl() {
        topics = new ArrayList<>();
    }

    public ConferenceImpl(Conference conference) {
        this.id = conference.getId();
        this.date = conference.getDate();
        this.name = conference.getName();
        this.anAbstract = conference.getAbstract();
        this.location = conference.getLocation();
        this.contact = conference.getContact();
        this.canceled = conference.isCanceled();
        topics = new ArrayList<>();
        conference.getTopics().forEach(this::addTopic);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbstract(String anAbstract) {
        this.anAbstract = anAbstract;
    }

    @Override
    public String getAbstract() {
        return anAbstract;
    }

    public void setAnAbstract(String anAbstract) {
        this.anAbstract = anAbstract;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void addTopic(Topic t) {
        if (t == null) return;
        if (topics.contains(t)) return;
        if (!topicValidator.isValid(t)) return;
        topics.add(t);
    }

    @Override
    public List<Topic> getTopics() {
        return Collections.unmodifiableList(topics);
    }

    @Override
    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
