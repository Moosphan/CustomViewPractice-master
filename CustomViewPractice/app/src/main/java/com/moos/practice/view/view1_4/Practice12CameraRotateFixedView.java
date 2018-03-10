package com.moos.practice.view.view1_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moos.practice.R;

public class Practice12CameraRotateFixedView extends View {
    /**
     * 修复拉伸问题,canvas与camera并没有直接联系，而是通过matrix
     */
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();


    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 绘制内容的中心点
         */
        int center1_x = point1.x + bitmap.getWidth()/2;
        int center1_y = point1.y + bitmap.getHeight()/2;
        int center2_x = point2.x + bitmap.getWidth()/2;
        int center2_y = point2.y + bitmap.getHeight()/2;


        /**
         * 保存camera状态
         */
        camera.save();
        matrix.reset();
        /**
         * 三维旋转
         */
        camera.rotateX(45);
        /**
         * 在保存camera状态前获取matrix，来修正大小和对称性
         */
        camera.getMatrix(matrix);
        camera.restore();
        /**
         * 在三维旋转前将绘制中心点移动到原点，再将三维旋转后的投影移动回来
         */
        matrix.preTranslate(-center1_x,-center1_y);
        matrix.postTranslate(center1_x,center1_y);
        /**
         * 保存canvas状态
         */
        canvas.save();
        /**
         * 将matrix应用到canvas上
         */
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        camera.save();
        matrix.reset();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-center2_x,-center2_y);
        matrix.postTranslate(center2_x,center2_y);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
