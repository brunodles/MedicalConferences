package com.github.brunodles.medicalconferences.validator;

import com.github.brunodles.medicalconferences.entity.Conference;
import com.mscharhag.oleaster.matcher.matchers.BooleanMatcher;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import static com.github.brunodles.medicalconferences.Factory.conference;
import static com.github.brunodles.medicalconferences.Factory.contact;
import static com.github.brunodles.medicalconferences.Factory.date;
import static com.github.brunodles.medicalconferences.Helper.INVALID_STRINGS;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

/**
 * Created by bruno on 14/03/16.
 */
@RunWith(OleasterRunner.class)
public class ConferenceValidatorTest {

    private ConferenceValidator conferenceValidator;
    private Conference conference;

    {
        describe("Given a ConferenceValidator", () -> {
            before(() -> {
                conferenceValidator = new ConferenceValidator();
            });

            describe("When validate a conference", () -> {
                beforeEach(() -> {
                    conference = conference();
                });

                it("should not be valid without a name", () -> {
                    INVALID_STRINGS.forEach(s -> {
                        conference.setName(s);
                        expectValidation().toBeFalse();
                    });
                });

                it("should not be valid without a contact", () -> {
                    conference.setContact(null);
                    expectValidation().toBeFalse();
                });

                it("should not be valid without a location", () -> {
                    INVALID_STRINGS.forEach(s -> {
                        conference.setLocation(s);
                        expectValidation().toBeFalse();
                    });
                });

                it("should not be valid without a date", () -> {
                    conference.setDate(null);
                    expectValidation().toBeFalse();
                });

                it("should be valid with name, conact, location and date", () -> {
                    conference = new Conference();
                    conference.setName("My conference");
                    conference.setContact(contact());
                    conference.setDate(date("03.01.2017"));
                    conference.setLocation("Maceió, Brazil");
                    expectValidation().toBeTrue();
                });

            });
        });
    }

    private BooleanMatcher expectValidation() {
        return expect(conferenceValidator.isValid(conference));
    }
}
