package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moos.practice.R;

/**
 * Created by moos on 2018/3/4.
 * func:光照颜色过滤
 */

public class PracticeLightingColorFilterView extends View {
    private Paint mPaint;
    public PracticeLightingColorFilterView(Context context) {
        super(context);
        init();
    }

    public PracticeLightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeLightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ColorFilter colorFilter = new LightingColorFilter(0x0f0fff,0x000000);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap,100,100,mPaint);
        /**
         * 增强绿色的色彩度
         */
        ColorFilter colorFilter1 = new LightingColorFilter(0xffffff,0x005000);
        mPaint.setColorFilter(colorFilter1);
        canvas.drawBitmap(bitmap,600,100,mPaint);

    }
}
