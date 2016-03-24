package com.github.brunodles.medicalconferences;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.Contact;
import com.github.brunodles.medicalconferences.entity.Invite;
import com.github.brunodles.medicalconferences.entity.Topic;
import com.github.brunodles.medicalconferences.entity.TopicProposal;
import com.github.brunodles.medicalconferences.entity.User;
import com.github.brunodles.medicalconferences.entity_impl.ConferenceImpl;
import com.github.brunodles.medicalconferences.entity_impl.ContactImpl;
import com.github.brunodles.medicalconferences.entity_impl.InviteImpl;
import com.github.brunodles.medicalconferences.entity_impl.TopicImpl;
import com.github.brunodles.medicalconferences.entity_impl.TopicProposalImpl;
import com.github.brunodles.medicalconferences.entity_impl.UserImpl;

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

    public static ConferenceImpl conference() {
        ConferenceImpl conference = new ConferenceImpl();
        conference.setDate(date("2016.03.15"));
        conference.setName("Investigating Incidents and The Duty of Candour");
        conference.setAbstract("The Statutory Duty of Candour came into force on the 27th November 2014.");
        conference.setLocation("London, United Kingdom");
        conference.setContact(contact());
        conference.addTopic(topic1());
        conference.addTopic(topic2());
        conference.addTopic(topic3());
        return conference;
    }

    public static Conference conference2() {
        ConferenceImpl conference = new ConferenceImpl();
        conference.setDate(date("2016.05.20"));
        conference.setName("Symposium Silent Contributors Injury/Illness/Performance");
        conference.setAbstract("Planning Periodization – Training errors, planning for performance, monitoring injury/illness/performance, planning for the gaps and travel, Pathology Specific");
        conference.setLocation("Bruce, Australia");
        return conference;
    }

    public static Topic topic1() {
        return new TopicImpl("Patient Safety", user());
    }

    public static Topic topic2() {
        return new TopicImpl("Incidents", user());
    }

    public static Topic topic3() {
        return new TopicImpl("Report writing", user());
    }

    public static ContactImpl contact() {
        ContactImpl contact = new ContactImpl();
        contact.setName("Leonard McCoy");
        contact.setEmail("mccoy@enterprise.com");
        contact.setPhone("99999-8888");
        return contact;
    }

    public static User user() {
        UserImpl user = new UserImpl();
        user.setName("Doctor Spock");
        user.setLogin("spock");
        user.setPassword("vulcan");
        return user;
    }

    public static User admin() {
        UserImpl user = new UserImpl();
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

    public static Invite invite() {
        return new InviteImpl(user(), conference());
    }

    public static Invite invite2() {
        return new InviteImpl(user(), conference2());
    }

    public static TopicProposal topicProposal() {
        return new TopicProposalImpl(conference(), "Main Topic", admin());
    }

    public static TopicProposal topicProposal2() {
        return new TopicProposalImpl(conference(), "Second topic", user());
    }
}
