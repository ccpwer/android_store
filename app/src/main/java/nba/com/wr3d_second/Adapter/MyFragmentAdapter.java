package nba.com.wr3d_second.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import nba.com.wr3d_second.Fragment.CategoryFragment;
import nba.com.wr3d_second.Fragment.DailyPopularFragment;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        return CategoryFragment.getInstance();
        else if (position == 1) {
            return DailyPopularFragment.getInstance();
        }
        else
            return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Rencents";

            case 1:
                return "Most Popular";

        }
        return "";
    }
}
