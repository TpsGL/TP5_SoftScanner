package logger;
import LogManager;
import org.apache.logging.log4j.*;
public class LoggingHelper {
    static final Logger logger = LogManager.getLogger("GLOBAL");

    private static LoggingHelper instance;

    private LoggingHelper() {
    }

    public static LoggingHelper getInstance() {
        if (instance == null) {
            instance = new LoggingHelper();
        }
        return instance;
    }

    public void log(Operation operation) {
        logger.info(new JSONMessage(operation.toMap()));
    }
}