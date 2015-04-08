package core;

import sun.util.logging.resources.logging;

/**
 * Created by Matthew on 08/04/2015.
 */
public class Logger {

    private static final boolean logging = false;

    public static void println(Object o) {
        if (logging) {
            System.out.println(o);
        }
    }
}
