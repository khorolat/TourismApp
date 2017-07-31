package articlesapp.zack.com.touristman;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 7/31/2017.
 */

public class TourGuidePagerAdapter extends FragmentPagerAdapter{

    private final int PAGE_COUNT = 4;

    private String tabTitles[] = new String[]{
            NightlifeFragment.NAME,
            SchoolFragment.NAME,
            MallFragment.NAME,
            RestaurantFragment.NAME};

    private Context mContext;

    public TourGuidePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new NightlifeFragment();
                break;
            case 1:
                fragment = new SchoolFragment();
                break;
            case 2:
                fragment = new MallFragment();
                break;
            case 3:
                fragment = new RestaurantFragment();
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}