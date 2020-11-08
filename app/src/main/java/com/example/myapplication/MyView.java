package com.example.myapplication;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    public float X = 50;
    public float Y = 50;

    //创建画笔
    Paint paint = new Paint();

    public MyView(Context context, AttributeSet set)
    {
        super(context,set);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint.setColor(Color.BLUE);
        //canvas.drawCircle(X,Y,100,paint);
        canvas.drawColor(getResources().getColor(R.color.colorPrimary));   //设置画布背景颜色
       // canvas.drawCircle(200, 200, 100, paint);           //画实心圆
       // canvas.drawRect(0, 0, 200, 100, paint);            //画矩形
        //canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 0, 0, paint);
       // canvas.drawArc(new RectF(100, 100, 400, 400),0,90,true,paint);  //绘制弧形区域
       // canvas.drawRoundRect(new RectF(10,10,410,810),15,15,paint); //画圆角矩形
        canvas.drawOval(new RectF(200,100,0,0),paint); //画椭圆
        /*Path path = new Path();
        //path.moveTo(10, 10); //移动到 坐标10,10
        path.lineTo(100, 50);
        path.lineTo(200,40);
        path.lineTo(300, 20);
        path.lineTo(200, 10);
        path.lineTo(100, 70);
        path.lineTo(50, 40);
        path.close();
        canvas.drawPath(path,paint);*/
        //canvas.drawText("最喜欢看曹神日狗了~",50,50,paint);    //绘制文字
        /*Path path = new Path();
        path.moveTo(50,50);
        path.lineTo(100, 100);
        path.lineTo(200, 200);
        path.lineTo(300, 300);
        path.close();
        canvas.drawTextOnPath("最喜欢看曹神日狗了~", path, 50, 50, paint);    //绘制文字*/
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.X = event.getX();
        this.Y = event.getY();
        //通知组件进行重绘
        this.invalidate();
        return true;
    }

    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);          //抗锯齿
        paint.setColor(getResources().getColor(R.color.colorAccent));//画笔颜色
        paint.setStyle(Paint.Style.FILL);  //画笔风格
        paint.setTextSize(36);             //绘制文字大小，单位px
        paint.setStrokeWidth(5);           //画笔粗细
    }
}
