package com.example.jiaozipeng0709;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    
    
    //声明画笔
    private Paint paint;
    ///声明路径
    private Path path;
    private Canvas mcanvas;
    private Bitmap bitmap;
    private Bitmap outbitmap;
    
    //声明坐标
    private int lastX;
    private int lastY;

    //重写的方法
    public MyView(Context context) {
        super(context);
        init(context);
    }



    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取控件的宽高
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        //初始化Bitmap
        bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        mcanvas = new Canvas(bitmap);

        //设置画笔的属性
//
//        setbackPaint();

      /*  canvas.drawRoundRect(new RectF(0,0,width,height),30,30,paint);
        canvas.drawBitmap(outbitmap,null,new RectF(0,0,width,height),null);*/




        setontPaint();

       mcanvas.drawColor(Color.parseColor("#c0c0c0"));

    }



    @Override
    protected void onDraw(Canvas canvas) {




        paint.setStyle(Paint.Style.STROKE);
        //DET_OUT这类似橡皮擦
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        canvas.drawBitmap(outbitmap,0,0,null);
        canvas.drawBitmap(bitmap,0,0,null);

        //中间层
        mcanvas.drawPath(path,paint);
        //下面层






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;

                path.moveTo(lastX,lastY);

                break;

                case MotionEvent.ACTION_MOVE:
                    int dx = Math.abs(x - lastX);
                    int dy = Math.abs(y - lastY);
                    if(dx>3 || dy>3){

                        path.lineTo(x,y);
                    }

                    lastX = x;
                    lastY = y;
                    break;

        }
        invalidate();
        return true;
    }

    private void init(Context context, AttributeSet attrs) {

        init(context);
    }
    //画笔的方法
    private void setontPaint() {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setDither(true);
    }

    private void init(Context context) {

        paint = new Paint();
        path = new Path();

        outbitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.dd);






    }

}
