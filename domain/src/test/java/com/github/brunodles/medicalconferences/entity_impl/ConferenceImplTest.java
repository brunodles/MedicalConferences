package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Topic;
import com.github.brunodles.medicalconferences.entity_impl.ConferenceImpl;
import com.github.brunodles.medicalconferences.entity_impl.TopicImpl;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.util.List;

import static com.github.brunodles.medicalconferences.Factory.topic1;
import static com.github.brunodles.medicalconferences.Factory.topic2;
import static com.github.brunodles.medicalconferences.Factory.topic3;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static java.util.Arrays.asList;

/**
 * Created by bruno on 14/03/16.
 */
@RunWith(OleasterRunner.class)
public class ConferenceImplTest {

    private ConferenceImpl conference;

    private static final List<Topic> TOPICS = asList(topic1(), topic2(), topic3());

    private final Topic topic = topic1();

    {
        describe("Given a Conference", () -> {
            beforeEach(() -> {
                conference = new ConferenceImpl();
            });

            describe("When getTopics is called", () -> {

                describe("When any topic was added", () -> {

                    it("should return a empty list", () -> {
                        List<Topic> topics = conference.getTopics();
                        expect(topics.size()).toEqual(0L);
                        expect(topics.isEmpty()).toBeTrue();
                    });

                });

                describe("When add a topic", () -> {

                    beforeEach(() -> conference.addTopic(topic));

                    it("should return the added topic", () -> {
                        List<Topic> topics = conference.getTopics();
                        expect(topics.size()).toEqual(1L);
                        expect(topics.isEmpty()).toBeFalse();
                        expect(topics.get(0)).toEqual(topic);
                    });

                });

                describe("When add few topics", () -> {

                    beforeEach(() -> {
                        TOPICS.forEach(conference::addTopic);
                    });

                    it("should return the topic list", () -> {
                        expect(conference.getTopics()).toEqual(TOPICS);
                    });
                });

                describe("When add a invalid topic", () -> {

                    beforeEach(() -> {
                        TOPICS.forEach(conference::addTopic);
                    });

                    describe("When add a invalid topic to conference", () -> {

                        beforeEach(() -> {
                            conference.addTopic(new TopicImpl());
                        });

                        itShouldBeIgnored();

                    });

                    describe("When add a null to topics list", () -> {

                        beforeEach(() -> {
                            conference.addTopic(null);
                        });

                        itShouldBeIgnored();

                    });

                    describe("When add the same topic", () -> {

                        beforeEach(() -> {
                            conference.addTopic(TOPICS.get(0));
                        });

                        itShouldBeIgnored();

                    });
                });
            });
        });
    }

    private void itShouldBeIgnored() {
        it("should be ignored", () -> {
            expect(conference.getTopics()).toEqual(TOPICS);
        });
    }
}