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

public class PracticeStrokeJoinView extends View {
    private Paint mPaint;
    private Path path = new Path();
    public PracticeStrokeJoinView(Context context) {
        super(context);
        init();
    }

    public PracticeStrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeStrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(42);
    }

    {
        path.rLineTo(200,0);
        path.rLineTo(-180,180);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(100,100);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path,mPaint);

        canvas.translate(300,0);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path,mPaint);

        canvas.translate(300,0);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path,mPaint);

        canvas.restore();
    }
}
