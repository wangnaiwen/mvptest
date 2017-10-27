package com.wnw.wnw.mvptest.download;

import android.app.Application;


/**
 *
 * @author wnw
 *
 * @date 2017/10/27 0027 11:37
 *
 */
public class RxRetrofitApp {
    private static Application application;
    private static boolean debug;


    /**
     * Init.
     *
     * @param app the app
     */
    public static void init(Application app){
        setApplication(app);
        setDebug(true);
    }

    /**
     * Init.
     *
     * @param app   the app
     * @param debug the debug
     */
    public static void init(Application app,boolean debug){
        setApplication(app);
        setDebug(debug);
    }

    /**
     * Gets application.
     *
     * @return the application
     */
    public static Application getApplication() {
        return application;
    }

    private static void setApplication(Application application) {
        RxRetrofitApp.application = application;
    }

    /**
     * Is debug boolean.
     *
     * @return the boolean
     */
    public static boolean isDebug() {
        return debug;
    }

    /**
     * Sets debug.
     *
     * @param debug the debug
     */
    public static void setDebug(boolean debug) {
        RxRetrofitApp.debug = debug;
    }
}
