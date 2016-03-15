package com.github.brunodles.medicalconferences.common;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.Contact;
import com.github.brunodles.medicalconferences.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bruno on 14/03/16.
 */
public class Factory {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");

    private Factory() {
    }

    public static Conference conference() {
        Conference conference = new Conference();
        conference.setDate(date("2016.03.15"));
        conference.setName("Investigating Incidents and The Duty of Candour");
        conference.setAbstract("The Statutory Duty of Candour came into force on the 27th November 2014.");
        conference.setLocation("London, United Kingdom");
        conference.setContact(contact());
        conference.addTopic("Patient Safety");
        conference.addTopic("Incidents");
        conference.addTopic("Report writing");
        return conference;
    }

    public static Contact contact() {
        Contact contact = new Contact();
        contact.setName("Leonard McCoy");
        contact.setEmail("mccoy@enterprise.com");
        contact.setPhone("99999-8888");
        return contact;
    }

    public static User user() {
        User user = new User();
        user.setName("Doctor Spock");
        user.setLogin("spock");
        user.setPassword("vulcan");
        return user;
    }

    public static User admin() {
        User user = new User();
        user.setName("James Tiberius Kirk");
        user.setLogin("kirk");
        user.setPassword("enterprise");
        user.setAdmin(true);
        return user;
    }

    public static Date date(String s) {
        try {
            return DATE_FORMAT.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
