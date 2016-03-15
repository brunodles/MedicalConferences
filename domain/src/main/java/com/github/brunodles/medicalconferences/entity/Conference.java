package com.github.brunodles.medicalconferences.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by bruno on 14/03/16.
 */
public class Conference {
    private Long id;
    private Date date;
    private String name;
    private String anAbstract;
    private String location;
    private Contact contact;
    private List<String> topics;
    private boolean canceled;

    public Conference() {
        topics = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAbstract(String anAbstract) {
        this.anAbstract = anAbstract;
    }

    public String getAnAbstract() {
        return anAbstract;
    }

    public void setAnAbstract(String anAbstract) {
        this.anAbstract = anAbstract;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void addTopic(String s) {
        if (s == null || s.isEmpty()) return;
        if (topics.contains(s)) return;
        topics.add(s);
    }

    public List<String> getTopics() {
        return Collections.unmodifiableList(topics);
    }


    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
