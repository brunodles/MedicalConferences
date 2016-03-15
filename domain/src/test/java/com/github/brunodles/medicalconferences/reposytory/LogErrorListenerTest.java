package com.github.brunodles.medicalconferences.reposytory;

import com.mscharhag.oleaster.runner.OleasterRunner;

import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static com.mscharhag.oleaster.runner.StaticRunnerSupport.after;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by bruno on 15/03/16.
 */
@RunWith(OleasterRunner.class)
public class LogErrorListenerTest {

    private Listener listener;

    private PrintStream sysErr;
    private PrintStream oldSysErr;

    {
        describe("Given a Listener", () -> {
            before(() -> {
                oldSysErr = System.err;
                sysErr = spy(ignorePrintStream());
                System.setErr(sysErr);
                listener = LogErrorListener.get();
            });

            describe("when a error happens", () -> {
                before(() -> {
                    listener.onFinish(new Exception());
                });

                it("should call print on System.err", () -> {
                    verify(sysErr, atLeastOnce()).print(any(String.class));
                });
            });

            after(() -> System.setErr(oldSysErr));
        });
    }

    private PrintStream ignorePrintStream() {
        return new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            }
        });
    }
}