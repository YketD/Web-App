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

    public ArrayList<User> getUsers()
    {
        return users;
    }

    public User getUser(String username)
    {
        for(User user : users)
            if (user.getUsername().equals(username))
                return user;

        return null;
    }

    public User getUser(String username, String password)
    {
        for(User user : users)
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;

        return null;
    }
}
