package learn.ijpds.ch33netw.nlogging.javautil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {
    private static final Logger logger = Logger.getLogger("learn.ijpds.ch33netw.nlogging.javautil");

    public static void main(String[] args) {
        logger.entering(LogDemo.class.getName(), "main");
        Object obj = new Object();
        logger.info("I created an object: " + obj);
        logger.logp(Level.INFO, "LogDemo", "main", "I created an object: " + obj);
        logger.exiting(LogDemo.class.getName(), "main");
    }
}
