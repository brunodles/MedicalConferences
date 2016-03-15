package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.Factory;
import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.Repository;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import static com.github.brunodles.medicalconferences.Factory.conference;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bruno on 14/03/16.
 */
@RunWith(OleasterRunner.class)
public class SchedulerTest {

    private Repository<Conference> repo;
    private Finder<Conference, Long> finder;
    private Scheduler scheduler;

    private Conference conference;

    private boolean result;

    {
        describe("Given a Scheduler", () -> {

            beforeEach(() -> {
                repo = mock(Repository.class);
                finder = mock(Finder.class);
                scheduler = new Scheduler(repo, finder);
            });

            describe("When schedule a new Conference", () -> {

                describe("When a valid conference is added", () -> {

                    beforeEach(() -> {
                        conference = Factory.conference();
                        result = scheduler.add(conference);
                    });

                    it("should return true", () -> {
                        expect(result).toBeTrue();
                    });

                    it("should add the conference on the repository", () -> {
                        verify(repo, only()).create(eq(conference), any(Listener.class));
                    });

                });

                describe("When the conference is invalid", () -> {

                    beforeEach(() -> {
                        conference = new Conference();
                        result = scheduler.add(conference);
                    });

                    it("should return false", () -> {
                        expect(result).toBeFalse();
                    });

                    it("should not add the conference into database", () -> {
                        verify(repo, never()).create(eq(conference), any(Listener.class));
                    });

                });
            });

            describe("When edit a conference", () -> {

                beforeEach(() -> {
                    Conference c = conference();
                    c.setId(1L);
                    when(finder.get(1L)).thenReturn(c);
                });

                describe("When get it from scheduler list", () -> {
                    beforeEach(() -> {
                        conference = scheduler.get(1L);
                        conference.setName("New name");
                        scheduler.edit(conference);
                    });

                    it("should return call repository.update", () -> {
                        verify(repo, only()).update(eq(conference), any(Listener.class));
                    });

                });
            });

            describe("When cancel a conference", () -> {

                describe("When using a conference object", () -> {

                    beforeEach(() -> {
                        conference = conference();
                        conference.setId(1L);
                        result = scheduler.cancel(conference);
                    });

                    it("should return true", () -> {
                        expect(result).toBeTrue();
                    });

                });

                describe("When using a valid conference id", () -> {
                    beforeEach(() -> {
                        conference = conference();
                        when(finder.get(1L)).thenReturn(conference);
                        result = scheduler.cancel(1L);
                    });

                    it("should return a true", () -> {
                        expect(result).toBeTrue();
                    });

                    it("should use finder to get the object", () -> {
                        verify(finder, only()).get(1L);
                    });

                    it("should update the conference on repository", () -> {
                        verify(repo, only()).update(eq(conference), any(Listener.class));
                    });

                });

                describe("When using a invalid conference id", () -> {
                    beforeEach(() -> {
                        when(finder.get(1L)).thenReturn(null);
                        result = scheduler.cancel(1);
                    });

                    it("should return false", () -> {
                        expect(result).toBeFalse();
                    });

                    it("should not update the conference on repository", () -> {
                        verify(repo, never()).update(any(Conference.class), any(Listener.class));
                    });

                });

            });
        });
    }
}