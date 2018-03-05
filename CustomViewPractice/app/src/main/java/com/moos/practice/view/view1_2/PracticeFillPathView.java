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

public class PracticeFillPathView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();
    public PracticeFillPathView(Context context) {
        super(context);
    }

    public PracticeFillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticeFillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        pathPaint.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.getFillPath() 获取实际绘制的 Path

        // 第一处：获取 Path
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0);
        paint.getFillPath(path, path1);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        canvas.drawPath(path1, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        paint.setStyle(Paint.Style.STROKE);
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        paint.getFillPath(path, path2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        canvas.drawPath(path2, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        paint.setStrokeWidth(40);
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        paint.getFillPath(path, path3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        canvas.drawPath(path3, pathPaint);
        canvas.restore();
    }
}
