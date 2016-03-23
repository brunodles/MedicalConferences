package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.Factory;
import com.github.brunodles.medicalconferences.entity.Conference;
import com.github.brunodles.medicalconferences.entity.TopicProposal;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.Repository;
import com.github.brunodles.medicalconferences.reposytory.TopicProposalFinder;
import com.github.brunodles.medicalconferences.reposytory.TopicProposalRepository;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.github.brunodles.medicalconferences.Factory.conference;
import static com.github.brunodles.medicalconferences.Factory.user;
import static com.github.brunodles.medicalconferences.Helper.INVALID_STRINGS;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static java.util.Collections.emptyList;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(OleasterRunner.class)
public class TopicProposerTest {

    private TopicProposer topicProposer;
    private TopicProposalRepository repo;
    private TopicProposalFinder finder;

    private boolean result;

    private List<TopicProposal> topicList;

    {
        describe("Given a TopicProposer", () -> {

            before(() -> {
                repo = mock(TopicProposalRepository.class);
                finder = mock(TopicProposalFinder.class);
                topicProposer = new TopicProposer(repo, finder);
            });

            describe("When propose a Topic to a Conference", () -> {

                describe("When is a valid propose", () -> {
                    before(() -> {
                        result = topicProposer.propose(conference(), "New Topic", user());
                    });

                    it("should return true", () -> {
                        expect(result).toBeTrue();
                    });

                    it("should be added on topic propose repository", () -> {
                        verify(repo, only()).create(any(TopicProposal.class), any(Listener.class));
                    });

                });

                INVALID_STRINGS.forEach(topic -> {

                    describe(String.format("When the suggested topic is \"%s\"", topic), () -> {

                        before(() -> {
                            result = topicProposer.propose(conference(), topic, user());
                        });

                        itShouldReturnFalse();

                        itShouldNotUseTheRepository();

                    });

                });

                describe("When the conference is null", () -> {

                    before(() -> {
                        result = topicProposer.propose(null, "New Topic", user());
                    });

                    itShouldReturnFalse();

                    itShouldNotUseTheRepository();

                });

                describe("When the user is null", () -> {

                    before(() -> {
                        result = topicProposer.propose(conference(), "New Topic", null);
                    });

                    itShouldReturnFalse();

                    itShouldNotUseTheRepository();

                });

            });

            describe("When get Proposal List", () -> {
                beforeEach(() -> {
                    topicList = topicProposer.topicsFor(conference());
                });

                describe("When no proposal as added", () -> {

                    before(() -> {
                        when(finder.findBy(anyString(), anyObject())).thenReturn(finder);
                        when(finder.list()).thenReturn(emptyList());
                    });

                    it("should return a empty list", () -> {
                        expect(topicList.size()).toEqual(0L);
                        expect(topicList.isEmpty()).toBeTrue();
                    });

                    it("should get the list from finder", () -> {
                        verify(finder, atLeastOnce()).findBy(anyString(), anyObject());
                        verify(finder, atLeastOnce()).list();
                    });

                });

                describe("When add proposals before", () -> {
                    before(() -> {
                        when(finder.findBy(anyString(), anyObject())).thenReturn(finder);
                        ArrayList<TopicProposal> list = new ArrayList<>();
                        list.add(Factory.topicProposal());
                        list.add(Factory.topicProposal2());
                        when(finder.list()).thenReturn(list);
                    });

                    it("should return a list with all proposal for the conference", () -> {
                        expect(topicList.size()).toEqual(2L);
                        expect(topicList.isEmpty()).toBeFalse();
                    });

                    it("should use finder to get the list", () -> {
                        verify(finder, atLeastOnce()).findBy(eq("conference"), any(Conference.class));
                    });
                });

            });

        });
    }

    private void itShouldNotUseTheRepository() {
        it("should not use the repository", () -> {
            verify(repo, never()).create(anyObject(), any(Listener.class));
            verify(repo, never()).update(anyObject(), any(Listener.class));
            verify(repo, never()).delete(anyObject(), any(Listener.class));
        });
    }

    private void itShouldReturnFalse() {
        it("should return false", () -> {
            expect(result).toBeFalse();
        });
    }
}
