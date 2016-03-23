package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.Factory;
import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.reposytory.ConferenceFinder;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(OleasterRunner.class)
public class CalendarTest {

    private ConferenceFinder finder;

    private Calendar calendar;

    private List<Conference> conferenceList;

    {
        describe("Given a calendar", () -> {
            before(() -> {
                finder = mock(ConferenceFinder.class);
                when(finder.findBy(eq("startDate"), any(Date.class))).thenReturn(finder);
                calendar = new Calendar(finder);
            });

            describe("When look for upcoming conferenceList", () -> {

                beforeEach(() -> {
                    conferenceList = calendar.listNextConferences();
                });

                describe("When there's no upcoming conference", () -> {

                    it("should return a emptyList", () -> {
                        expect(conferenceList.size()).toEqual(0L);
                        expect(conferenceList.isEmpty()).toBeTrue();
                    });

                    itShouldGetTheListFromFinder();

                });

                describe("When there's upcoming conferences", () -> {

                    before(() -> {
                        ArrayList<Conference> list = new ArrayList<>();
                        list.add(Factory.conference());
                        list.add(Factory.conference2());
                        when(finder.list()).thenReturn(list);
                    });

                    it("should return a list containing all conferences", () -> {
                        expect(conferenceList.size()).toBeGreaterThan(0);
                        expect(conferenceList.isEmpty()).toBeFalse();
                    });

                    itShouldGetTheListFromFinder();
                });

            });

        });
    }

    private void itShouldGetTheListFromFinder() {
        it("should get the list from finder", () -> {
            verify(finder, atLeastOnce()).list();
        });
    }
}
