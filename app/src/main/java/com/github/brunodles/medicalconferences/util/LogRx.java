package com.github.brunodles.medicalconferences.util;

import android.util.Log;

import rx.functions.Action1;

/**
 * Created by bruno on 16/10/15.
 */
public final class LogRx implements Action1 {
    private String tag;
    private String msg;

    public static Action1<Throwable> e(String tag) {
        return new LogRx(tag);
    }

    public static Action1<Throwable> e(String tag, String msg) {
        return new LogRx(tag, msg);
    }

    public static Action1<? super Object> d(String tag, String msg) {
        return new LogRx(tag, msg);
    }

    private LogRx(String tag) {
        this.tag = tag;
        msg = "call: ";
    }

    public LogRx(String tag, String msg) {
        this.tag = tag;
        this.msg = msg;
    }

    @Override
    public void call(Object o) {
        if (o instanceof Throwable)
            Log.e(tag, msg, (Throwable) o);
        else
            Log.d(tag, String.format("%s %s", msg, o));
    }
}
