package com.github.brunodles.medicalconferences.validator;

import com.github.brunodles.medicalconferences.Factory;
import com.github.brunodles.medicalconferences.entity.Contact;
import com.mscharhag.oleaster.matcher.matchers.BooleanMatcher;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

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
public class ContactValidatorTest {

    private ContactValidator contactValidator;

    private Contact contact;

    {
        describe("Given a ContactValidator", () -> {
            before(() -> {
                contactValidator = new ContactValidator();
            });

            describe("When validate a Contact", () -> {
                beforeEach(() -> {
                    contact = Factory.contact();
                });

                it("should not be valid without a name", () -> {
                    INVALID_STRINGS.forEach(s -> {
                        contact.setName(s);
                        expectValidation().toBeFalse();
                    });
                });

                it("should be valid with name and email", () -> {
                    contact.setPhone(null);
                    expectValidation().toBeTrue();
                });

                it("should be valid with name and phone", () -> {
                    contact.setEmail(null);
                    expectValidation().toBeTrue();
                });

                it("should not be valid with empty phone", () -> {
                    contact.setPhone("");
                    expectValidation().toBeFalse();
                });

                it("should not be valid with empty email", () -> {
                    contact.setEmail("");
                    expectValidation().toBeFalse();
                });

            });
        });
    }

    private BooleanMatcher expectValidation() {
        return expect(contactValidator.isValid(contact));
    }
}
