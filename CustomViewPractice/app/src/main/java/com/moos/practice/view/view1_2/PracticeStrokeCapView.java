package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/4.
 */

public class PracticeStrokeCapView extends View {
    private Paint mPaint;
    public PracticeStrokeCapView(Context context) {
        super(context);
        init();
    }

    public PracticeStrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeStrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(30);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(150, 50, 400, 50, mPaint);

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(150, 150, 400, 150, mPaint);

        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(150, 250, 400, 250, mPaint);
    }
}
