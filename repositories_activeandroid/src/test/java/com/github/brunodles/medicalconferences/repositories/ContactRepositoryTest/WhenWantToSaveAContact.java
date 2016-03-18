package com.github.brunodles.medicalconferences.repositories.ContactRepositoryTest;

import android.os.Build;

import com.github.brunodles.medicalconferences.TestApplication;
import com.github.brunodles.medicalconferences.entity.Contact;
import com.github.brunodles.medicalconferences.repositories.BuildConfig;
import com.github.brunodles.medicalconferences.repositories.ContactRepository;
import com.github.brunodles.medicalconferences.reposytory.Listener;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.JELLY_BEAN,
        application = TestApplication.class,
        constants = BuildConfig.class)
public class WhenWantToSaveAContact {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ContactRepository repository;
    private Contact contact;
    @Mock Listener listener;

    @Before
    public void before() {
        repository = new ContactRepository();
        contact = new Contact();
        contact.setName("Anakin Skywalker");
        contact.setPhone("99999-8888");
        contact.setEmail("anakin@deathstar.com");
    }

    @Test
    public void shouldBeAbleToSaveData() {
        repository.create(contact, listener);
    }
}