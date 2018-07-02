package com.example.mydemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.mydemo.R;

/**
 * Created by user on 2018/4/11.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustomView1 extends View {

    Paint paint = new Paint();//画笔

    Path path = new Path(); // 初始化 Path 对象

//    {
//        // 使用 path 对图形进行描述（这段描述代码不必看懂）
//        path.addArc(200, 200, 400, 400, -225, 225);
//        path.arcTo(400, 200, 600, 400, -180, 225, false);
//        path.lineTo(400, 542);
//    }

    public CustomView1(Context context) {
        super(context);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        paint.setColor(Color.RED);
        //画笔类型：FILL 填充模式, FILL_AND_STROKE,STROKE 画线模式，
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(20);
        //是否抗锯齿
        paint.setAntiAlias(true);

        //整体颜色填充(三种方式)
//        canvas.drawColor(Color.parseColor("#88880000"));
//        canvas.drawRGB(100,200,100);
//        canvas.drawARGB(100,100,200,100);

        //画圆
//        canvas.drawCircle(200, 200, 100, paint);
        //画椭圆
//        canvas.drawArc(100,100,300,500,0,-180,false,paint);

        //画矩形
//        canvas.drawRect(100,100,600,600,paint);
        //画圆角矩形
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRoundRect(100,100,500,300,50,50,paint);

        //画点
//        paint.setStrokeWidth(40);//设置点的大小
//        paint.setStrokeCap(Paint.Cap.SQUARE);//设置点的形状，圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE)
//        canvas.drawPoint(100,100,paint);

        //画线
//        canvas.drawLine(200,200,40,400,paint);

        //自定义图形
        path.setFillType(Path.FillType.EVEN_ODD);
        path.addCircle(200,200,100, Path.Direction.CCW);
        path.addCircle(300,200,100, Path.Direction.CCW);
        canvas.drawPath(path,paint);

    }
}
