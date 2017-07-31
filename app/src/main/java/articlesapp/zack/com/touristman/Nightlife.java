package articlesapp.zack.com.touristman;

/**
 * Created by Admin on 7/31/2017.
 */

public class Nightlife {

    String nightlifeId;
    String nightlifeName;
    String nightlifeAddress;


    public Nightlife() {

    }

    public Nightlife(String nightlifeId, String nightlifeName, String nightlifeAddress) {
        this.nightlifeId = nightlifeId;
        this.nightlifeName = nightlifeName;
        this.nightlifeAddress = nightlifeAddress;

    }

    public String getNightlifeId() {
        return nightlifeId;
    }

    public String getNightlifeName() {
        return nightlifeName;
    }

    public String getNightlifeAddress() {
        return nightlifeAddress;

    }
}

