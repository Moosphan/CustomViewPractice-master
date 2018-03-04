package com.moos.practice.view.view1_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/2.
 */

public class PracticePointView extends View {
    private Paint mPaint;
    public PracticePointView(Context context) {
        super(context);
        init();
    }

    public PracticePointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticePointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        mPaint.setStrokeWidth(80);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(400, 300, mPaint);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(800,300, mPaint);

    }
}
