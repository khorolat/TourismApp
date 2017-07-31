package articlesapp.zack.com.touristman;

/**
 * Created by Admin on 7/31/2017.
 */

public class Malls {

    String mallId;
    String mallName;
    String mallAddress;


    public Malls() {

    }

    public Malls(String mallId, String mallName, String mallAddress) {
        this.mallId = mallId;
        this.mallName = mallName;
        this.mallAddress = mallAddress;

    }

    public String getMallId() {
        return mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public String getMallAddress() {return mallAddress;

    }
}
