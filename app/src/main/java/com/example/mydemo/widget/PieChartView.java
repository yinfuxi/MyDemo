package com.example.mydemo.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.mylibrary.utils.LogUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 2018/5/7.
 */

public class PieChartView extends View {

    private static final int DEFAULT_RADIUS = 200;//默认半径


    private Map<String, Integer> kindsMap = new LinkedHashMap<String, Integer>();//存放事物的品种与其对应的数量
    private ArrayList<Integer> colors = new ArrayList<>();//存放颜色
    private int sum = 0;//总数量


    private Paint mPaint;//饼状画笔
    private Paint textPaint;//文字画笔
    private int mRadius = DEFAULT_RADIUS;//默认半径
    private RectF oval;//圆所在的矩形范围
    private float animatedValue;

    public PieChartView(Context context) {
        super(context);
        init();
        LogUtils.d("init1");
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        LogUtils.d("init2");
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        LogUtils.d("init3");

    }

    /**
     * 初始化画笔
     */
    private void init() {
        LogUtils.d("init");
        mPaint = new Paint();
        textPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextAlign(Paint.Align.CENTER);//文字居中

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wideSize = MeasureSpec.getSize(widthMeasureSpec);
        int wideMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width, height;

        /**
         *  MeasureSpec
         1.精确模式（MeasureSpec.EXACTLY）

         在这种模式下，尺寸的值是多少，那么这个组件的长或宽就是多少。

         2.最大模式（MeasureSpec.AT_MOST）

         这个也就是父组件，能够给出的最大的空间，当前组件的长或宽最大只能为这么大，当然也可以比这个小。

         3.未指定模式（MeasureSpec.UNSPECIFIED）

         这个就是说，当前组件，可以随便用空间，不受限制。
         */
        //算实际宽度
        if (wideMode == MeasureSpec.EXACTLY) {//有精确值或matchParent时
            width = wideSize;
        } else {
            width = mRadius * 2 + getPaddingLeft() + getPaddingRight();
            if (wideMode == MeasureSpec.AT_MOST) {
                width = Math.min(width, wideSize);
            }
        }

        //算实际高
        if (heightMode == MeasureSpec.EXACTLY) { //精确值 或matchParent
            height = heightSize;
        } else {
            height = mRadius * 2 + getPaddingTop() + getPaddingBottom();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, heightSize);
            }
        }
        //设置view实际宽高
        setMeasuredDimension(width, height);

        //计算实际半径
        mRadius = Math.min(width - getPaddingLeft() - getPaddingRight(), height - getPaddingLeft() - getPaddingRight());
        LogUtils.d("mRadius = " + mRadius);

        //圆所在的矩形范围
        oval = new RectF(0, 0, mRadius, mRadius);
        initAnimator();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paintPieChart(canvas);
    }

    /**
     * 花圆饼
     */
    private void paintPieChart(final Canvas canvas) {


        if (kindsMap != null) {
            Set<Map.Entry<String, Integer>> entrySet = kindsMap.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

            int i = 0;
            float currentAngle = 0.0f;//当前角度
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                int mun = entry.getValue();
                float needDrawAngle = mun * 1.0f / sum * 360;
                if (Math.min(needDrawAngle - 1, animatedValue - currentAngle) >= 0) {
                    mPaint.setColor(colors.get(i));
                    canvas.drawArc(oval, currentAngle, Math.min(needDrawAngle - 1, animatedValue - currentAngle), true, mPaint);
                    i++;
                    LogUtils.d("animatedValue = " + animatedValue + "--i=" + i);
                }
                currentAngle += needDrawAngle;

            }
        }


    }

    private void initAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0, 360);
        anim.setDuration(10000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatedValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        anim.start();
    }

    /**
     * 设置数据
     *
     * @param kindsMap Map<String, Integer> kindsMap
     */
    public void setKindsMap(Map<String, Integer> kindsMap) {
        this.kindsMap = kindsMap;
        sum = getSum(kindsMap);
    }

    private int getSum(Map<String, Integer> kindsMap) {
        int sums = 0;
        if (kindsMap != null) {
            Set<String> set = kindsMap.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String kinds = iterator.next();
                int num = kindsMap.get(kinds);
                sums += num;
            }

        }
        return sums;
    }

    public void setColors(ArrayList<Integer> colors) {
        this.colors = colors;
    }


}
