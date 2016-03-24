package com.github.brunodles.medicalconferences.common;

/**
 * Created by bruno on 04/09/15.
 */
public final class StringValidator {

    private StringValidator() {
    }

    public static boolean isNullOrEmpty(String string) {
        return (string == null) || (string.length() == 0);
    }


}
