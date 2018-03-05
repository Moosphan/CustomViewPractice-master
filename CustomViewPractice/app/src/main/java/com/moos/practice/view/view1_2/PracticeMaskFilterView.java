package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moos.practice.R;

/**
 * Created by moos on 2018/3/4.
 * 设置绘制上方的mask效果
 */

public class PracticeMaskFilterView extends View {
    private Paint mPaint;
    MaskFilter maskFilter1 = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
    MaskFilter maskFilter2 = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
    MaskFilter maskFilter3 = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);
    MaskFilter maskFilter4 = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);
    public PracticeMaskFilterView(Context context) {
        super(context);
        init();
    }

    public PracticeMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /***
         * 模糊效果
         */
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mPaint.setMaskFilter(maskFilter1);
        canvas.drawBitmap(bitmap, 100, 50, mPaint);

        mPaint.setMaskFilter(maskFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, mPaint);

        mPaint.setMaskFilter(maskFilter3);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, mPaint);

        mPaint.setMaskFilter(maskFilter4);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, mPaint);


    }
}
