package com.example.buddyapp4.ui.main;

import android.content.Context;
import android.content.Intent;
import android.util.EventLog;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.buddyapp4.EventBoardFragment;
import com.example.buddyapp4.MainActivity;
import com.example.buddyapp4.ProfileFragment;
import com.example.buddyapp4.R;
import com.example.buddyapp4.User;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES =
            new int[]{R.string.eventBoard, R.string.topTenBoard, R.string.profileBoard};
    private final Context mContext;
    private final User currentUser;

    public SectionsPagerAdapter(Context context, FragmentManager fm, User user) {
        super(fm);
        mContext = context;
        currentUser = user;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = EventBoardFragment.newInstance("","");
                break;
            case 1:
                fragment = PlaceholderFragment.newInstance(position + 1);
                break;
            case 2:
                fragment = ProfileFragment.newInstance(currentUser, "");
                break;
        }
        return fragment;
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