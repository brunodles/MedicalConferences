package com.github.brunodles.medicalconferences.repositories.dtos;

import android.os.Build;

import com.activeandroid.ActiveAndroid;
import com.github.brunodles.medicalconferences.TestApplication;
import com.github.brunodles.medicalconferences.repositories.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.JELLY_BEAN,
        application = TestApplication.class,
        constants = BuildConfig.class)
public class ContactTest {

    @Test
    public void shouldBeAbleToCallContactSave(){
        Contact contact = new Contact();
        contact.name = ("Anakin Skywalker");
        contact.phone = ("99999-8888");
        contact.email = ("anakin@deathstar.com");

        Long id = contact.save();
        assertTrue("The id should be greater than zero", id > 0);

    }
}