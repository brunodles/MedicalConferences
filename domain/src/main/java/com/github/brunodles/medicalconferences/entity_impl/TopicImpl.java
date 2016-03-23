package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Topic;
import com.github.brunodles.medicalconferences.entity.User;

/**
 * Created by bruno on 23/03/16.
 */
public class TopicImpl implements Topic {

    private Long id;
    private String title;
    private User speaker;

    public TopicImpl() {
    }

    public TopicImpl(String title, User speaker) {
        this.title = title;
        this.speaker = speaker;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicImpl topic = (TopicImpl) o;

        if (id != null ? !id.equals(topic.id) : topic.id != null) return false;
        if (title != null ? !title.equals(topic.title) : topic.title != null) return false;
        return speaker != null ? speaker.equals(topic.speaker) : topic.speaker == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (speaker != null ? speaker.hashCode() : 0);
        return result;
    }
}
