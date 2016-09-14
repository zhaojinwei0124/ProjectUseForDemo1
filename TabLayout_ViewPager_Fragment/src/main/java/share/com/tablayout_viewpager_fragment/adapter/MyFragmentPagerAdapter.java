package share.com.tablayout_viewpager_fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by qiush on 2016/9/12.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    Fragment[] fragments;
    public MyFragmentPagerAdapter(FragmentManager fm,Fragment[] fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "tab1";
        }else if(position==1){
            return "tab2";
        }else if(position==2){
            return "tab3";
        }else{
            return "更多的";
        }
    }
}