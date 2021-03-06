package com.fakestergrampackage.fakestergram;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fakestergrampackage.fakestergram.FeedFragment;
import com.fakestergrampackage.fakestergram.ProfileFragment;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    /*private final String locationName;
    private final String locationKey;*/

    private Singleton singleton = Singleton.getInstance();

    //private FirebaseAuth firebaseAuth = ref

    public SectionsPagerAdapter(Context context, FragmentManager fm,
                                        String locationName, String locationKey) {
        super(fm);
        mContext = context;

        /*this.locationName = locationName;
        this.locationKey = locationKey;*/

    }

    /**
     * Get the fragment to use for each position.
     * 0 = Today's Weather
     * 1 = Five Day Forecast
     * 2 = City Weather
     * @param position
     * @return The fragment to display in each position.
     */
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return FeedFragment.newInstance();
                //return FeedFragment.newInstance(locationName, locationKey);

            case 1:
                return new ProfileFragment().newInstance();

            /*case 2:
                return new CityWeatherFragment();*/

            default:
                 return PlaceholderFragment.newInstance(position + 1);
        }
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

}