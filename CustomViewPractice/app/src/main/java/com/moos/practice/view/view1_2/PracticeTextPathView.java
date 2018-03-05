package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/4.
 */

public class PracticeTextPathView extends View {
    private Paint mPaint,pathPaint;
    private Path textPath = new Path();
    public PracticeTextPathView(Context context) {
        super(context);
        init();
    }

    public PracticeTextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeTextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint = new Paint();
        pathPaint = new Paint();
        pathPaint.setStyle(Paint.Style.STROKE);
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(120);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = "我学习我快乐";
        canvas.drawText(str,200,100,mPaint);
        mPaint.getTextPath(str,0,str.length(),200,500,textPath);

        canvas.drawPath(textPath,pathPaint);
    }
}
