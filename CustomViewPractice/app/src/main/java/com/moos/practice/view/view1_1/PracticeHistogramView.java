package com.moos.practice.view.view1_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by moos on 2018/3/2.
 * func:绘制直方图
 */

public class PracticeHistogramView extends View {
    private Paint mPaint;
    private Path mPath;
    private final float RECT_WIDTH_EACH = 100f;//每个矩形的宽度固定
    private final float RECT_DISTANCE = 20f;//每个矩形的间隔
    private final float AXIS_Y_START_POINT_X = 100;
    private final float AXIS_Y_START_POINT_Y = 100;
    private final float AXIS_Y_END_POINT_X = 100;
    private final float AXIS_Y_END_POINT_Y = 800;
    private float currentDistance = RECT_DISTANCE + AXIS_Y_START_POINT_X;//当前x轴已占据的距离
    private final float WORD_OFFSET = 30;//文字相对于x轴偏移量

    public PracticeHistogramView(Context context) {
        super(context);
        init();
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawAxis(canvas);
        {
            mPaint.setStyle(Paint.Style.FILL);
            drawRectAndText(canvas, 10, "Dart");
            drawRectAndText(canvas, 80, "Java");
            drawRectAndText(canvas, 280, "Android");
            drawRectAndText(canvas, 380, "Ios");
            drawRectAndText(canvas, 220, "Python");
            drawRectAndText(canvas, 100, "Kotlin");
            currentDistance = RECT_DISTANCE + AXIS_Y_START_POINT_X;
        }

    }

    /**
     * by moos on 2018/03/02
     * func:绘制x，y轴
     * @param canvas
     */
    private void drawAxis(Canvas canvas){
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(100, 100);
        mPath.lineTo(100, 800);
        mPath.rLineTo(800, 0);
        canvas.drawPath(mPath, mPaint);
    }

    /**
     * by moos on 2018/03/02
     * func:绘制矩形和文字
     * @param canvas
     * @param rectHeight
     * @param title
     */
    private void drawRectAndText(Canvas canvas, float rectHeight, String title) {
        mPaint.setColor(Color.GREEN);
        Log.e("HistogramView:","当前矩形起点坐标x为="+currentDistance);
        canvas.drawRect(currentDistance, AXIS_Y_END_POINT_Y - rectHeight, RECT_WIDTH_EACH + currentDistance, AXIS_Y_END_POINT_Y, mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(18);
        canvas.drawText(title, currentDistance + WORD_OFFSET, AXIS_Y_END_POINT_Y + WORD_OFFSET , mPaint);
        currentDistance = currentDistance + RECT_DISTANCE +RECT_WIDTH_EACH;// 下一个矩形的位置

    }
}
