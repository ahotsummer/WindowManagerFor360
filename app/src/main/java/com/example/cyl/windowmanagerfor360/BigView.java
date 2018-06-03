package com.example.cyl.windowmanagerfor360;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by cyl on 2018/6/3.
 */

public class BigView extends LinearLayout {
    /**
     * 记录大悬浮窗的宽度
     */
    public static int viewWidth;

    /**
     * 记录大悬浮窗的高度
     */
    public static int viewHeight;
    public BigView(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.win_big, null);
        //View view = findViewById(R.id.big);
        viewWidth = view.getWidth();
        viewHeight = view.getHeight();
        Log.e("cyl",""+view.getWidth());
        Log.e("cyl",""+view.getLayoutParams().width);
        Button close = (Button) view.findViewById(R.id.close);
        Button back = (Button) view.findViewById(R.id.back);
        close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关闭悬浮窗的时候，移除所有悬浮窗，并停止Service
                MyWindowManager.removeBigWindow(context);
                MyWindowManager.removeSmallWindow(context);
                Intent intent = new Intent(getContext(), MyService.class);
                context.stopService(intent);
            }
        });
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击返回的时候，移除大悬浮窗，创建小悬浮窗
                MyWindowManager.removeBigWindow(context);
                MyWindowManager.createSmallWindow(context);
            }
        });
    }
}
