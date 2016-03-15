package com.github.brunodles.medicalconferences.common;

import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.util.List;

import static com.github.brunodles.medicalconferences.common.StringValidator.isNullOrEmpty;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(OleasterRunner.class)
public class StringValidatorTest {

    private static final List<String> VALID_STRINGS = asList("Valid", "a Valid String", "This should pass too");
    private static final List<String> INVALID_STRINGS = asList("", null);

    {
        describe("When call isNullOrEmpty", () -> {

            withStringsShouldReturn(VALID_STRINGS, false);

            withStringsShouldReturn(INVALID_STRINGS, true);
        });

    }

    private void withStringsShouldReturn(List<String> list, boolean value) {
        String valid = value ? "invalid" : "valid";
        describe("With a " + valid + " string", () -> {

            it("should return " + value, () -> {
                list.forEach(s -> {
                    assertEquals(value, isNullOrEmpty(s));
                });
            });

        });
    }
}