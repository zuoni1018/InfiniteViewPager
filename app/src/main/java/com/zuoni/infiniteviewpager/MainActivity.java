package com.zuoni.infiniteviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private InfiniteViewPager viewPager;
    private InfinitePagerAdapter pagerAdapter;
    //记录上一次滑动的positionOffsetPixels值
    int lastValue = -1;
    boolean isLeft = true;
    private int nowNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (InfiniteViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new InfinitePagerAdapter(getSupportFragmentManager());
        viewPager.setPagerAdapter(pagerAdapter);
        viewPager.setCurrentItem(1, false);

    }
}
