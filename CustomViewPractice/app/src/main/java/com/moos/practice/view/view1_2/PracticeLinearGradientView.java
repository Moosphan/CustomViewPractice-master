package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by moos on 2018/3/4.
 * func:使用线性渐变来绘制颜色
 */

public class PracticeLinearGradientView extends View {
    private Paint mPaint;
    public PracticeLinearGradientView(Context context) {
        super(context);
        init();
    }

    public PracticeLinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeLinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Shader shader = new LinearGradient(100,100,800,800, Color.parseColor("#e91e65"),Color.parseColor("#2596f3"),Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawRect(200,200,800,500,mPaint);

    }
}
