package Model;

import java.util.ArrayList;
/**
 * Created by yketd on 1-9-2016.
 */
public class ApplicationData
{
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Appartement> appartements = new ArrayList<>();

    private static ApplicationData ourInstance = new ApplicationData();

    public static ApplicationData getInstance() {
        return ourInstance;
    }

    private ApplicationData()
    {
        // Pre-defined users
        users.add(new User("admin", "admin", true));

        appartements.add(new Appartement(2,3000,"Enschede"));
        appartements.add(new Appartement(4,2000,"Enschede"));
        appartements.add(new Appartement(6,8000,"Deventer"));
    }

    public ArrayList<User> getUsers()
    {
        return users;
    }

    public ArrayList<Appartement> getAppartements() {
        return appartements;
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

    public void addUser(User newUser)
    {
        if (getUser(newUser.getUsername())!= null)
            users.remove(getUser(newUser.getUsername()));
        users.add(newUser);
    }
}
