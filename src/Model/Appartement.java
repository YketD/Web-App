package Model;

/**
 * Created by yketd on 1-9-2016.
 */
public class Appartement {
    int sqrmtr;
    int maxprijs;
    String plaats;

    public Appartement(int m2, int maxprijs, String plaats){
        this.maxprijs = maxprijs;
        this.plaats = plaats;
        this.sqrmtr = m2;
    }

    public int getSqrmtr() {
        return sqrmtr;
    }

    public int getMaxprijs() {
        return maxprijs;
    }

    public String getPlaats() {
        return plaats;
    }
}
