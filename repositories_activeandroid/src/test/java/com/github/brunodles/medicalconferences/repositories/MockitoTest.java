package com.github.brunodles.medicalconferences.repositories;

import android.os.Build;

import com.github.brunodles.medicalconferences.TestApplication;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.JELLY_BEAN,
        application = TestApplication.class,
        constants = BuildConfig.class)
public class MockitoTest {

//    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void shouldBeAbleToGetTextFromResources() {
        CharSequence text = RuntimeEnvironment.application.getText(R.string.app_name);
        assertEquals("repositories", text);
    }
}