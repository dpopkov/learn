package learn.ijpds.ch33netw.nlogging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo {
    final static Logger theLogger = LoggerFactory.getLogger(Slf4jDemo.class);

    public static void main(String[] args) {
        System.out.println("Logger class: " + theLogger.getClass().getName());
        Object obj = new Object();
        theLogger.info("I created an object: {}", obj);
    }
}
