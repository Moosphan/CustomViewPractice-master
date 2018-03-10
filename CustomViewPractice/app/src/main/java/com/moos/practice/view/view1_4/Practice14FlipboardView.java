package com.moos.practice.view.view1_4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.moos.practice.R;

/**
 * 折纸效果
 */
public class Practice14FlipboardView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    int degree;
    /**
     * 好好学习一下属性动画的使用（此处degree对应变量的set方法）
     */
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);

    public Practice14FlipboardView(Context context) {
        super(context);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        /**
         * 绘制静止的上半部分
         */
        canvas.save();
        canvas.clipRect(x, y, centerX+bitmapWidth/2, centerY);
        canvas.drawBitmap(bitmap,x, y, paint);
        canvas.restore();

        /**
         * 绘制三维翻转的下半部分
         */
        canvas.save();

        camera.save();
        matrix.reset();
        camera.rotateX(degree);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(- centerX,- centerY);
        matrix.postTranslate(centerX,centerY);
        canvas.concat(matrix);
        canvas.clipRect(x,centerY,centerX+bitmapWidth/2,centerY+bitmapHeight/2);
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();
    }
}
