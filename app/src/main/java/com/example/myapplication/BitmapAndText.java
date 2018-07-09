package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BitmapAndText extends View {



    //声明画笔
    private Paint paint;
    //声明全区区域
    private Region globalregion;
    //声明局部的
    private Region partregion;
    //声明接口
    private setClickList listener;

    public BitmapAndText(Context context) {
        super(context);
        init(context);
    }

    public BitmapAndText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context,attrs);

    }




    public BitmapAndText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }



    private void init(Context context) {

        //创建画笔
        Paint paint = new Paint();
        //创建颜色
        paint.setColor(Color.BLACK);
        //设置样式
        paint.setStyle(Paint.Style.STROKE);
        //设置区域的宽度
        paint.setStrokeWidth(5);

        //new yige
        globalregion = new Region();
        partregion= new Region();

    }

    private void init(Context context, AttributeSet attrs) {

        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //设置全局区域范围
        Rect rect = new Rect(0,0,oldw,oldh);
        globalregion.set(rect);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        canvas.drawBitmap(bitmap,200,200,paint);


        //设置局部区域的
        Path path = new Path();
        path.addCircle(200,200,100,Path.Direction.CW);


        //切割圆形区域
        partregion.setPath(path,globalregion);

        //花圆形
        canvas.drawPath(path,paint);




    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                //获取点击坐标
                int x = (int) event.getX();
                int y = (int) event.getY();



                if(partregion.contains(x,y)){


                    if(listener!=null){
                        listener.innerToast(this);

                    }else{
                        if(listener!=null){
                            listener.outnerToast(this);

                        }
                    }




                }

        }
        return super.onTouchEvent(event);
    }

    //第一步定义接口
    public  interface   setClickList{
        Void innerToast(View view);
        Void outnerToast(View view);
    }


}
