package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.Factory;
import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity_impl.ConferenceImpl;
import com.github.brunodles.medicalconferences.reposytory.ConferenceFinder;
import com.github.brunodles.medicalconferences.reposytory.ConferenceRepository;
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

    private ConferenceRepository repo;
    private ConferenceFinder finder;
    private Scheduler scheduler;

    private Conference conference;

    private boolean result;

    {
        describe("Given a Scheduler", () -> {

            beforeEach(() -> {
                repo = mock(ConferenceRepository.class);
                finder = mock(ConferenceFinder.class);
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
                        conference = new ConferenceImpl();
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
                    conference = scheduler.get(1L);
                    ConferenceImpl c = new ConferenceImpl(conference());
                    c.setName("New Name");
                    conference = c;
                    result = scheduler.edit(c);
                });

                it("should return true", () -> {
                    expect(result).toBeTrue();
                });

                it("should call repository.update", () -> {
                    verify(repo, only()).update(eq(conference), any(Listener.class));
                });
            });

            describe("When cancel a conference", () -> {

                describe("When using a conference object", () -> {

                    beforeEach(() -> {
                        conference = conference();
                        conference = scheduler.cancel(conference);
                    });

                    it("should return true when call isCanceled", () -> {
                        expect(conference.isCanceled()).toBeTrue();
                    });

                });

            });
        });
    }
}