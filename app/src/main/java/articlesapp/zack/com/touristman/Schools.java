package articlesapp.zack.com.touristman;

/**
 * Created by Admin on 7/31/2017.
 */

public class Schools {

    String schoolsId;
    String schoolsName;
    String schoolsAddress;


    public Schools() {

    }

    public Schools(String schoolId, String schoolName, String schoolAddress) {
        this.schoolsId = schoolId;
        this.schoolsName = schoolName;
        this.schoolsAddress = schoolAddress;

    }

    public String getSchoolId() {
        return schoolsId;
    }

    public String getSchoolName() {
        return schoolsName;
    }

    public String getSchoolAddress() {
        return schoolsAddress;

    }
}

