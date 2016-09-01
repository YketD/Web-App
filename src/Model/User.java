package Model;

/**
 * Created by yketd on 1-9-2016.
 */
public class User
{
    private String username;
    private String password;
    private boolean isOwner;

    public User(String username, String password, boolean isOwner)
    {
        this.username = username;
        this.password = password;
        this.isOwner = isOwner;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isOwner()
    {
        return isOwner;
    }
}
