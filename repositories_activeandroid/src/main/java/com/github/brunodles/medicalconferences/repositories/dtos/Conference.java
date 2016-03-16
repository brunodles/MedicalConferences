package com.github.brunodles.medicalconferences.repositories.dtos;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

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
public class Conference extends Model {
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
    public Contact contact;
    public List<String> topics;
    @Column(name = COLUMN_CANCELED)
    public boolean canceled;

    public Conference() {
    }

    public Conference(com.github.brunodles.medicalconferences.entity.Conference conference) {
        this.id = conference.getId();
        this.anAbstract = conference.getAnAbstract();
        this.canceled = conference.isCanceled();
        this.date = conference.getDate();
        this.location = conference.getLocation();
        this.name = conference.getName();
//        this.topics =
        this.contact = new Contact(conference.getContact());
    }
}
