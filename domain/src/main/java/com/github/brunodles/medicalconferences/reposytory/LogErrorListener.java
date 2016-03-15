package com.github.brunodles.medicalconferences.reposytory;

/**
 * Created by bruno on 14/03/16.
 */
public class LogErrorListener implements Listener {

    private static LogErrorListener instance;

    private LogErrorListener() {
    }

    @Override
    public void onFinish(Exception error) {
        error.printStackTrace(System.err);
    }

    public static Listener get(){
        if (instance == null)
            instance = new LogErrorListener();
        return instance;
    }
}
