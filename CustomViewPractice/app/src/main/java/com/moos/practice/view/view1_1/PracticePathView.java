package com.moos.practice.view.view1_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/2.
 * func:绘制路径
 */

public class PracticePathView extends View {
    private Paint mPaint;
    public PracticePathView(Context context) {
        super(context);
        init();
    }

    public PracticePathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticePathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        Path path = new Path();
        path.addArc(300, 300, 500, 500, -230, 222);
        path.arcTo(500, 300, 700, 500, -180, 222, false);
        path.lineTo(500, 660);
        canvas.drawPath(path,mPaint);
    }
}
