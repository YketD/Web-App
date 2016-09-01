package Model;

import java.util.ArrayList;
/**
 * Created by yketd on 1-9-2016.
 */
public class ApplicationData
{
    private ArrayList<User> users = new ArrayList<>();

    private static ApplicationData ourInstance = new ApplicationData();

    public static ApplicationData getInstance() {
        return ourInstance;
    }

    private ApplicationData()
    {
        // Pre-defined users
        users.add(new User("admin", "admin", true));
    }
}
