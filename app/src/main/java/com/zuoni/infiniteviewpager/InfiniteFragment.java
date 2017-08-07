package com.zuoni.infiniteviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zangyi_shuai_ge on 2017/8/7
 */

public class InfiniteFragment extends Fragment {
    int color;


    private TextView tvNum;
    LinearLayout layout;

    public InfiniteFragment(int color) {
        this.color = color;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        tvNum = (TextView) view.findViewById(R.id.tvNum);
        tvNum.setText(color + "");
        layout = (LinearLayout) view.findViewById(R.id.layoutMain);


        return view;
    }

    public void notification(int nowNum) {
        if (tvNum != null) {
            tvNum.setText(nowNum + "");
            Log.i("设置数字", nowNum + "");
            color = nowNum % 3;
            if (color == 0) {
                layout.setBackgroundColor(getResources().getColor(R.color.colorAccent1));
            } else if (color == 1) {
                layout.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
            } else {
                layout.setBackgroundColor(getResources().getColor(R.color.colorAccent3));
            }
        }

    }


}
