package soexample.umeng.com.fzl20181213.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * date:2018/12/13
 * author:冯泽林(asus)
 * function:
 */
public class MyFragment extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> list;

    public MyFragment(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
