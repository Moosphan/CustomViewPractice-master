package com.moos.practice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/2.
 * func:绘制饼图
 */

public class PracticePieChartView extends View {
    private Paint mPaint;

    public PracticePieChartView(Context context) {
        super(context);
        init();
    }

    public PracticePieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticePieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.MAGENTA);
        canvas.drawArc(175, 175, 800, 800, -180, 120, true, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawArc(200, 200, 800, 800, -60, 70, true, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(200, 200, 800, 800, 15, 10, true, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(200, 200, 800, 800, 30, 25, true, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(190, 190, 810, 810, 60, 55, true, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(180, 180, 820, 820, 120, 55, true, mPaint);

    }
}
