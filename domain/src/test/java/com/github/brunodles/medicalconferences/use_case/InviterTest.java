package com.github.brunodles.medicalconferences.use_case;

import com.github.brunodles.medicalconferences.Factory;
import com.github.brunodles.medicalconferences.entity.Invite;
import com.github.brunodles.medicalconferences.entity.User;
import com.github.brunodles.medicalconferences.reposytory.Finder;
import com.github.brunodles.medicalconferences.reposytory.Listener;
import com.github.brunodles.medicalconferences.reposytory.Repository;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.github.brunodles.medicalconferences.Factory.conference;
import static com.github.brunodles.medicalconferences.Factory.user;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.beforeEach;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
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
public class InviterTest {

    private Inviter inviter;
    private Repository<Invite> repo;
    private Finder<Invite, Long> finder;

    private boolean result;

    private List<Invite> inviteList;

    private void itShouldNotCallRepository() {
        it("should not call the repository", () -> {
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

    {
        describe("Given a Inviter", () -> {
            before(() -> {
                repo = mock(Repository.class);
                finder = mock(Finder.class);
                inviter = new Inviter(repo, finder);
            });

            describe("When a Admin invite a doctor", () -> {
                before(() -> {
                    result = inviter.invite(user(), conference());
                });

                it("should return true", () -> {
                    expect(result).toBeTrue();
                });

                it("should be saved on repository", () -> {
                    verify(repo, only()).create(any(Invite.class), any(Listener.class));
                });

            });

            describe("When try to invite someone with invalid params", () -> {

                describe("When pass a null user", () -> {
                    before(() -> {
                        result = inviter.invite(null, conference());
                    });

                    itShouldReturnFalse();

                    itShouldNotCallRepository();
                });

                describe("When pass a null conference", () -> {
                    before(() -> {
                        result = inviter.invite(user(), null);
                    });

                    itShouldReturnFalse();

                    itShouldNotCallRepository();
                });

            });

            describe("When list invites to a user", () -> {
                beforeEach(() -> {
                    inviteList = inviter.listInvitesTo(user(), 10);
                });

                describe("When there's no invite", () -> {

                    before(() -> {
                        when(finder.findBy(eq("user"), anyObject())).thenReturn(finder);
                        when(finder.list(10)).thenReturn(new ArrayList<Invite>());
                    });

                    it("should return a empty list", () -> {
                        expect(inviteList.isEmpty()).toBeTrue();
                        expect(inviteList.size()).toEqual(0);
                    });

//                    it("should call finder 2 times", () -> {
//                        verify(finder, only()).findBy(eq("user"), any(User.class));
//                        verify(finder, only()).list(eq(10));
//                    });
                });

                describe("When a invite was added before", () -> {
                    before(() -> {
                        when(finder.findBy(eq("user"), anyObject())).thenReturn(finder);
                        ArrayList<Invite> list = new ArrayList<>();
                        list.add(Factory.invite());
                        list.add(Factory.invite2());
                        when(finder.list(10)).thenReturn(list);
                    });

                    it("should return a list with all invites", () -> {
                        expect(inviteList.size()).toEqual(2L);
                        expect(inviteList.isEmpty()).toBeFalse();
                    });

//                    it("should call finder", () -> {
//                        verify(finder, only()).findBy(anyString(), any(User.class));
//                        verify(finder, only()).list((10));
//                    });

                });
            });

        });
    }
}
