package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.entity.TopicProposal;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.Repository;
import com.github.brunodles.oleaster_suite_runner.OleasterSuiteRunner;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import static com.github.brunodles.medicalconferences.Factory.conference;
import static com.github.brunodles.medicalconferences.Helper.INVALID_STRINGS;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(OleasterRunner.class)
public class TopicProposerTest {

    private TopicProposer topicProposer;

    private Repository<TopicProposal> repo;

    private boolean result;

    {
        describe("Given a TopicProposer", () -> {

            before(() -> {
                repo = mock(Repository.class);
                topicProposer = new TopicProposer(repo);
            });

            describe("When propose a Topic to a Conference", () -> {

                describe("When is a valid propose", () -> {
                    before(() -> {
                        result = topicProposer.propose(conference(), "New Topic");
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
                            result = topicProposer.propose(conference(), topic);
                        });

                        itShouldReturnFalse();

                        itShouldNotUseTheRepository();

                    });

                });

                describe("When the conference is null", () -> {

                    before(() -> {
                        result = topicProposer.propose(null, "New Topic");
                    });

                    itShouldReturnFalse();

                    itShouldNotUseTheRepository();

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
