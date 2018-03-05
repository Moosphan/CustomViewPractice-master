package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moos.practice.R;

/**
 * Created by moos on 2018/3/4.
 * 颜色矩阵过滤
 */

public class PracticeColorMatrixColorFilterView extends View {
    private Paint mPaint;
    public PracticeColorMatrixColorFilterView(Context context) {
        super(context);
        init();
    }

    public PracticeColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap,200,200,mPaint);
    }
}
