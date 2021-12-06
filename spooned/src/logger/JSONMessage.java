package logger;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.message.Message;
public class JSONMessage implements Message {
    private String messageString;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public JSONMessage() {
        this(null);
    }

    public JSONMessage(Object msgObj) {
        parseMessageAsJson(msgObj);
    }

    public JSONMessage(String msgStr) {
        Map<String, String> msgObj = new HashMap<>();
        msgObj.put("message", msgStr);
        parseMessageAsJson(msgObj);
    }

    private void parseMessageAsJson(Object msgObj) {
        messageString = GSON.toJson(msgObj);
    }

    @Override
    public String getFormattedMessage() {
        return messageString;
    }

    @Override
    public String getFormat() {
        return messageString;
    }

    @Override
    public Object[] getParameters() {
        return new Object[0];
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }
}