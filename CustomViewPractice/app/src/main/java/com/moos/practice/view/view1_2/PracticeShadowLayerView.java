package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moos.practice.R;

/**
 * Created by moos on 2018/3/4.
 * 绘制阴影效果
 */

public class PracticeShadowLayerView extends View {
    private Paint mPaint;
    public PracticeShadowLayerView(Context context) {
        super(context);
        init();
    }

    public PracticeShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint.setShadowLayer(10,0,0, Color.parseColor("#6d88d3"));
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(120);
        canvas.drawText("绘制阴影效果",200,100,mPaint);

        /**
         * 除文字外的绘制阴影需要关闭硬件加速
         */

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        canvas.drawBitmap(bitmap,200,400,mPaint);
    }
}
