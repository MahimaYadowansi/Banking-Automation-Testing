package rough;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class TestLog {
	private static final Logger logger = LogManager.getLogger(TestLog.class);


	public static void main(String[] args) {
		// Ensure Log4j2 loads the correct configuration
        System.setProperty("log4j.configurationFile", System.getProperty("user.dir") + "/src/test/resources/properties/log4j2.xml");

        logger.trace("This is a TRACE log.");
        logger.debug("This is a DEBUG log.");
        logger.info("This is an INFO log.");
        logger.warn("This is a WARN log.");
        logger.error("This is an ERROR log.");
        logger.fatal("This is a FATAL log.");
    }
}
