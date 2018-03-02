package com.moos.practice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/2.
 * func:画弧线
 */

public class PracticeArcView extends View {
    private Paint mPaint;
    public PracticeArcView(Context context) {
        super(context);
        init();
    }

    public PracticeArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(300 ,200, 800, 600, -180, 60, false, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(300, 200, 800, 600, -110, 90, true,mPaint);
        canvas.drawArc(300, 200, 800, 600, 30, 120 ,false, mPaint);
    }
}
