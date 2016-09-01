import java.util.Map;

/**
 * Created by yketd on 1-9-2016.
 */
public class UserData {
    private Map<String, User> userdata;
    private static UserData ourInstance = new UserData();

    public static UserData getInstance() {
        return ourInstance;
    }

    private UserData() {
    }
}
