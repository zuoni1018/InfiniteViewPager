package com.zuoni.infiniteviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangyi_shuai_ge on 2017/4/21
 */

public class InfinitePagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private List<InfiniteFragment> mInfiniteFragmentList;

    private InfiniteFragment rightInfiniteFragment;
    private InfiniteFragment leftInfiniteFragment;
    private InfiniteFragment middleInfiniteFragment;
    private int middleNum = 1;

    public InfinitePagerAdapter(FragmentManager fm) {
        super(fm);
        mInfiniteFragmentList = new ArrayList<>();

        leftInfiniteFragment = new InfiniteFragment(0);
        middleInfiniteFragment = new InfiniteFragment(1);
        rightInfiniteFragment = new InfiniteFragment(2);
        mInfiniteFragmentList.add(leftInfiniteFragment);
        mInfiniteFragmentList.add(middleInfiniteFragment);
        mInfiniteFragmentList.add(rightInfiniteFragment);
    }

    @Override
    public int getCount() {
        return mInfiniteFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mInfiniteFragmentList.get(position);
    }


    public void notifyDataSetChanged(boolean isLeft) {
        if (middleInfiniteFragment != null) {
            if (isLeft) {
                middleNum = middleNum - 1;
            } else {
                middleNum = middleNum + 1;
            }
            middleInfiniteFragment.notification(middleNum);
            leftInfiniteFragment.notification(middleNum - 1);
            rightInfiniteFragment.notification(middleNum + 1);
        }

    }
}
