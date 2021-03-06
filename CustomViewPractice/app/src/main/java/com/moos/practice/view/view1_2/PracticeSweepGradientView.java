package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/4.
 */

public class PracticeSweepGradientView extends View {
    private Paint mPaint;
    public PracticeSweepGradientView(Context context) {
        super(context);
        init();
    }

    public PracticeSweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeSweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Shader shader = new SweepGradient(400,400, Color.parseColor("#e91e65"),Color.parseColor("#2596f3"));
        mPaint.setShader(shader);
        canvas.drawRect(200,200,800,500,mPaint);
    }
}
