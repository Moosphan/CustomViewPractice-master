package com.moos.practice.view.view1_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moos.practice.R;

/**
 * Created by moos on 2018/3/4.
 * 绘制内容与canvas已有内容的结合方式
 */

public class PracticeXfermodeView extends View {
    private Paint mPaint;
    Xfermode xfermode1 = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    Xfermode xfermode2 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Xfermode xfermode3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    public PracticeXfermodeView(Context context) {
        super(context);
        init();
    }

    public PracticeXfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeXfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 离屏缓存
         */
        int saved = canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.batman_logo);
        canvas.drawBitmap(bitmap1, 0, 0, mPaint);
        mPaint.setXfermode(xfermode1);
        canvas.drawBitmap(bitmap2, 0, 0, mPaint);
        mPaint.setXfermode(null);

        canvas.drawBitmap(bitmap1, bitmap1.getWidth() + 100, 0, mPaint);
        mPaint.setXfermode(xfermode2);
        canvas.drawBitmap(bitmap2, bitmap1.getWidth() + 100, 0, mPaint);
        mPaint.setXfermode(null);

        canvas.drawBitmap(bitmap1, 0, bitmap1.getHeight() + 20, mPaint);
        mPaint.setXfermode(xfermode3);
        canvas.drawBitmap(bitmap2, 0, bitmap1.getHeight() + 20, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(saved);
    }
}
