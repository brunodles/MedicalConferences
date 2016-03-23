package com.github.brunodles.medicalconferences.repositories.dtos;

import android.os.Build;

import com.github.brunodles.medicalconferences.TestApplication;
import com.github.brunodles.medicalconferences.repositories.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.JELLY_BEAN,
        application = TestApplication.class,
        constants = BuildConfig.class)
public class ContactRecordTest {

    @Test
    public void shouldBeAbleToCallContactSave(){
        ContactRecord contact = new ContactRecord();
        contact.setName("Anakin Skywalker");
        contact.setPhone("99999-8888");
        contact.setEmail("anakin@deathstar.com");

        Long id = contact.save();
        assertTrue("The id should be greater than zero", id > 0);

    }
}