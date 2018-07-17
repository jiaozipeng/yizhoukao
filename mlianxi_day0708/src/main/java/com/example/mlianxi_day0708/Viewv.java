package com.example.mlianxi_day0708;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Viewv extends View{

    //定义画笔
    private Paint paint;
    private String text= "123";
    private int color= Color.BLACK;




    public Viewv(Context context) {
        super(context);
        init(context);
    }

    public Viewv(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public Viewv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context) {

        paint= new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.STROKE);

    }
    private void init(Context context, AttributeSet attrs) {
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.addCircle(200,200,200,Path.Direction.CW);
        canvas.drawPath(path,paint);
Paint paint1=new Paint();
        paint1.setColor(color);
        paint1.setTextAlign(Paint.Align.CENTER);
        text="123";
        canvas.drawText(text,200,200,paint1);




    }
}
