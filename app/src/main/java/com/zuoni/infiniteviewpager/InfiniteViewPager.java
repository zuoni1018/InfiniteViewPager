package com.zuoni.infiniteviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by zangyi_shuai_ge on 2017/8/7
 * 可以左右无限切换的ViewPager
 * 类似网易云和日历左右切换切歌
 */

public class InfiniteViewPager extends ViewPager {

    //适配器
    private InfinitePagerAdapter pagerAdapter;

    public InfiniteViewPager(Context context) {
        this(context, null);
    }

    public InfiniteViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        //设置缓存页数
        this.setOffscreenPageLimit(2);
        //设置监听
        this.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (pagerAdapter != null) {
                    if (position == 0) {
                        //刚刚左滑
                        Log.e("onPageSelected", "--->左滑");
                        pagerAdapter.notifyDataSetChanged(true);
                        InfiniteViewPager.this.setCurrentItem(1, false);
                    } else if (position == 2) {
                        Log.e("onPageSelected", "--->右滑");
                        pagerAdapter.notifyDataSetChanged(false);
                        InfiniteViewPager.this.setCurrentItem(1, false);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void setPagerAdapter(InfinitePagerAdapter pagerAdapter) {
        this.pagerAdapter = pagerAdapter;
        setAdapter(pagerAdapter);
    }

}
