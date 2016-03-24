package com.github.brunodles.medicalconferences.repositories.dtos;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.Topic;

import java.util.Date;
import java.util.List;

import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_ABSTRACT;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_CANCELED;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_CONTACT;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_DATE;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_ID;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_LOCATION;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.COLUMN_NAME;
import static com.github.brunodles.medicalconferences.repositories.tables.ConferenceTable.TABLE;

/**
 * Created by bruno on 15/03/16.
 */

@Table(name = TABLE)
public class ConferenceRecord extends Model implements Conference {
    @Column(name = COLUMN_ID)
    public Long id;
    @Column(name = COLUMN_DATE)
    public Date date;
    @Column(name = COLUMN_NAME)
    public String name;
    @Column(name = COLUMN_ABSTRACT)
    public String anAbstract;
    @Column(name = COLUMN_LOCATION)
    public String location;
    @Column(name = COLUMN_CONTACT)
    public ContactRecord contactRecord;
    public List<Topic> topics;
    @Column(name = COLUMN_CANCELED)
    public boolean canceled;

    public ConferenceRecord() {
    }

    public ConferenceRecord(Conference conference) {
        this.id = conference.getId();
        this.anAbstract = conference.getAbstract();
        this.canceled = conference.isCanceled();
        this.date = conference.getDate();
        this.location = conference.getLocation();
        this.name = conference.getName();
//        this.topics =
        this.contactRecord = new ContactRecord(conference.getContact());
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAbstract() {
        return anAbstract;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public com.github.brunodles.medicalconferences.entity.Contact getContact() {
        return contactRecord;
    }

    @Override
    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public boolean isCanceled() {
        return canceled;
    }
}
