package articlesapp.zack.com.touristman;

/**
 * Created by Admin on 7/31/2017.
 */

public class Restaurant {

    String restaurantId;
    String restaurantName;
    String restaurantAddress;


    public Restaurant() {

    }

    public Restaurant(String restaurantId, String restaurantName, String restaurantAddress) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;

    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;

    }
}

