package share.com.tablayout_viewpager_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import share.com.tablayout_viewpager_fragment.adapter.MyFragmentPagerAdapter;
import share.com.tablayout_viewpager_fragment.fragments.Fragment1;
import share.com.tablayout_viewpager_fragment.fragments.Fragment2;
import share.com.tablayout_viewpager_fragment.fragments.Fragment3;

public class MainActivity extends AppCompatActivity {
    Fragment[] fragments;
    FragmentPagerAdapter adapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new Fragment[3];
        fragments[0]=new Fragment1();
        fragments[1]=new Fragment2();
        fragments[2]=new Fragment3();
        adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
