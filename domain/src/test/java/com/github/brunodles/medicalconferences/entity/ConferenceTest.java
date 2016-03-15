package com.github.brunodles.medicalconferences.entity;

import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.util.List;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static java.util.Arrays.asList;

/**
 * Created by bruno on 14/03/16.
 */
@RunWith(OleasterRunner.class)
public class ConferenceTest {

    private Conference conference;

    private static final List<String> TOPICS = asList("Topic1", "Topic2", "Topic3");

    {
        describe("Given a Conference", () -> {
            beforeEach(() -> {
                conference = new Conference();
            });

            describe("When getTopics is called", () -> {

                describe("When any topic was added", () -> {

                    it("should return a empty list", () -> {
                        List<String> topics = conference.getTopics();
                        expect(topics.size()).toEqual(0L);
                        expect(topics.isEmpty()).toBeTrue();
                    });

                });

                describe("When add a topic", () -> {

                    beforeEach(() -> conference.addTopic("Topic"));

                    it("should return the added topic", () -> {
                        List<String> topics = conference.getTopics();
                        expect(topics.size()).toEqual(1L);
                        expect(topics.isEmpty()).toBeFalse();
                        expect(topics.get(0)).toEqual("Topic");
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

                    describe("When add a empty string to topics list", () -> {

                        beforeEach(() -> {
                            conference.addTopic("");
                        });

                        itShouldBeIgnored();

                    });

                    describe("When add a nullto topics list", () -> {

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