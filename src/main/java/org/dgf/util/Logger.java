package org.dgf.util;

public final class Logger {
    private static boolean debug;
    private Logger(){

    }

    static {
        debug = Boolean.parseBoolean(System.getenv("debug"));
    }

    public static void debug(String message) {
        if(debug) {
            System.out.println("DEBUG : " + message);
        }
    }
    public static void info(String message) {
        System.out.println(message);
    }

    public static void warn(String message) {
        System.out.println("WARN : " + message);
    }

    public static void error(String message) {
        System.out.println("ERROR : " + message);
    }

}
