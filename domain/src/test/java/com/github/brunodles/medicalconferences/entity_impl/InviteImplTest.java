package com.github.brunodles.medicalconferences.entity_impl;

import com.github.brunodles.medicalconferences.entity.Invite;
import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import static com.github.brunodles.medicalconferences.Factory.conference;
import static com.github.brunodles.medicalconferences.Factory.user;
import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by bruno on 23/03/16.
 */
@RunWith(OleasterRunner.class)
public class InviteImplTest {

    private Invite invite;

    private Invite newInvite;

    {
        describe("Given a rejected Invite", () -> {
            before(() -> {
                InviteImpl i = new InviteImpl(user(), conference());
                i.setRejected();
                invite = i;
            });

            describe("When try to create a new invite", () -> {

                before(() -> {
                    newInvite = new InviteImpl(invite);
                });

                it("should be rejected", () -> {
                    expect(newInvite.isRejected()).toBeTrue();
                });
                it("should not be accepted", () -> {
                    expect(newInvite.isAccepted()).toBeFalse();
                });
            });

        });
        describe("Given a accepted Invite", () -> {
            before(() -> {
                InviteImpl i = new InviteImpl(user(), conference());
                i.setAccepted();
                invite = i;
            });

            describe("When try to create a new invite", () -> {

                before(() -> {
                    newInvite = new InviteImpl(invite);
                });

                it("should not be rejected", () -> {
                    expect(newInvite.isRejected()).toBeFalse();
                });
                it("should be accepted", () -> {
                    expect(newInvite.isAccepted()).toBeTrue();
                });
            });

        });
        describe("Given a Invite", () -> {
            before(() -> {
                invite = new InviteImpl(user(), conference());
            });

            describe("When try to create a new invite", () -> {

                before(() -> {
                    newInvite = new InviteImpl(invite);
                });

                it("should not be rejected", () -> {
                    expect(newInvite.isRejected()).toBeFalse();
                });
                it("should be accepted", () -> {
                    expect(newInvite.isAccepted()).toBeFalse();
                });
            });

        });
        describe("Given a miss-implemented Invite", () -> {
            before(() -> {
                Invite i = mock(Invite.class);
                when(i.isAccepted()).thenReturn(true);
                when(i.isRejected()).thenReturn(true);
                invite = i;
            });

            describe("When try to create a new invite", () -> {

                before(() -> {
                    newInvite = new InviteImpl(invite);
                });

                it("should not be rejected", () -> {
                    expect(newInvite.isRejected()).toBeFalse();
                });
                it("should be accepted", () -> {
                    expect(newInvite.isAccepted()).toBeFalse();
                });
            });

        });
    }
}