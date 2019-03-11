package learn.ijpds.ch33netw.nlogging.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JDemo {
    private static final Logger logger = Logger.getLogger(Log4JDemo.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        logger.info("entered method main()");
        Object obj = new Object();
        logger.error("I created an object: " + obj);
        logger.info("exiting method main()");
    }
}
