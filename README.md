# CustomViewPractice-master
Just for practicing custom views.

本仓库的目的是练习自定义的使用，题目来源于HenCoder:http://hencoder.com

由于前几章节知识较为简单，不再记录，从canvas篇开始有些难度，将陆续记录一些难点的消化式理解、心得以及拓展实战。

## Canvas篇

1. canvas.clipRect()/canvas.clipPath()方法会将后续的绘制内容限制在规定区域内，之后的canvas处理将基于该区域进行操作（如位移、旋转等几何变化）
2. 在自定义view中使用属性动画，属性动画中的propertyName支持自定义，但要提供set方法
3. auto动画一般在自定义view类中的onAttachedToWindow中开始，在onDetachedFromWindow中结束：
```
  @Override
  protected void onAttachedToWindow() {
  	 /**
      * 在activity的onResume时调用
      */
      super.onAttachedToWindow();
      animator.start();
  }

  @Override
  protected void onDetachedFromWindow() {
  	 /**
      * 在activity的onDestroy时调用
      */
      super.onDetachedFromWindow();
      animator.end();
  }
```
4. 修正三维变换时的糊脸问题，该参数系数到底该如何获取待后续研究：
```
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    float newZ = - displayMetrics.density * 6;
    camera.setLocation(0, 0, newZ);
```
5. 当使用camera进行3d旋转时，需要进行以下特殊处理来避免绘制内容的缩放、拉伸和非对称情况（即在三维旋转之前把绘制内容的中心点移动到原点，即旋转的轴心，然后在三维旋转后再把投影移动回来）：
- 方式一：
>Canvas 的几何变换顺序是反的，所以要把移动到中心的代码写在下面，把从中心移动回来的代码写在上面。该方式不利于理解，可以采用方式二。
```
    canvas.save();

    camera.save(); // 保存 Camera 的状态  
    camera.rotateX(30); // 旋转 Camera 的三维空间  
    canvas.translate(centerX, centerY); // 旋转之后把投影移动回来  
    camera.applyToCanvas(canvas); // 把旋转投影到 Canvas  
    canvas.translate(-centerX, -centerY); // 旋转之前把绘制内容移动到轴心（原点）  
    camera.restore(); // 恢复 Camera 的状态

    canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
    canvas.restore();

```
- 方式二：
>canvas与camera并没有直接联系，而是通过matrix。
```
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
```

6. 3d折纸效果的实现逻辑优化（可在最后绘制bitmap前裁剪区域，这样不需要判断角度大小问题）:
```
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
```
7. 3d翻转的方向速记方案：
>可以通过类似电路一门课中的左手定则和右手定则来帮助记忆。如果是绕x或者y轴旋转，那么左手握拳，大拇指指向x/y轴的正方向，四指环绕，指尖所指方向即为3d旋转方向，绕z轴旋转可同理依照右手定则来判断方向。
8. 问题（待后续查找资料再补充）：
- canvas.save()与canvas.restore()方法的真正意图，核心原理？
- canvas.concat(Matrix matrix)与canvas.setMatrix(Matrix matrix)方法的区别？
9. 拓展：
- 通过前后几章节内容来实现一个自定义的折纸飞机的效果







