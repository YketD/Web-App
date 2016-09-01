package Model;

import java.util.Map;

/**
 * Created by yketd on 1-9-2016.
 */
public class ApplicationData {
    private Map<String, User> userdata;

    private static ApplicationData ourInstance = new ApplicationData();

    public static ApplicationData getInstance() {
        return ourInstance;
    }

    private ApplicationData() {

    }
}
