package com.funcell.platform.android.game.authentication.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FuncellLoadingView extends View {
    private Paint mPaint;
    private int[] mColors = new int[]{0xB07ECBDA, 0xB0E6A92C, 0xB0D6014D, 0xB05ABA94};
    private static ArrayList<float[]> points;//�ĸ���Ҫ�������
    private int mCircleRadius = 20;
//    private int lineMax = 300;//ֱ�ߵ���󳤶�
    private int lineMax = 100;//ֱ�ߵ���󳤶�
    private int lineMin = 0;//ֱ�ߵ���̳���
    private float x, y;//��ת������
    private int mCanvasAngle = 0;//Ĭ�ϽǶ�
    private int type = 1;//��������
    private int mLineLength;//ֱ�߳���
    private int mPointMove = 0;//��λ�ƾ���

    public FuncellLoadingView(Context context) {
        this(context, null);
    }

    public FuncellLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FuncellLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColors[0]);
        init();
    }

    private void init() {
        mCircleRadius = 20;
//        lineMax = 300;
        lineMax = 100;
        lineMin = 0;
        mCanvasAngle = 0;
        type = 1;
        mPointMove = 0;
        mLineLength = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        switch (type) {
            case 1://��Բ+��ֱ��+��Բ
                canvas.rotate(mCanvasAngle, x, y);
                for (int i = 0; i < points.size(); i++) {
                    mPaint.setColor(mColors[i]);
                    float[] point = points.get(i);

                    switch (i) {
                        case 0:
                            canvas.drawArc(new RectF(point[0] - mCircleRadius, point[1] - mCircleRadius, point[0] + mCircleRadius, point[1] + mCircleRadius), 90, 180, true, mPaint);
                            canvas.drawRect(point[0], point[1] - mCircleRadius, point[0] + mLineLength, point[1] + mCircleRadius, mPaint);
                            canvas.drawArc(new RectF(point[0] + mLineLength - mCircleRadius, point[1] - mCircleRadius, point[0] + mLineLength + mCircleRadius, point[1] + mCircleRadius), 270, 180, true, mPaint);
                            break;
                        case 1:
                            canvas.drawArc(new RectF(point[0] - mCircleRadius, point[1] - mCircleRadius, point[0] + mCircleRadius, point[1] + mCircleRadius), 180, 180, true, mPaint);
                            canvas.drawRect(point[0] - mCircleRadius, point[1], point[0] + mCircleRadius, point[1] + mLineLength, mPaint);
                            canvas.drawArc(new RectF(point[0] - mCircleRadius, point[1] + mLineLength - mCircleRadius, point[0] + mCircleRadius, point[1] + mLineLength + mCircleRadius), 0, 180, true, mPaint);
                            break;
                        case 2:
                            canvas.drawArc(new RectF(point[0] - mCircleRadius, point[1] - mCircleRadius, point[0] + mCircleRadius, point[1] + mCircleRadius), 270, 180, true, mPaint);
                            canvas.drawRect(point[0] - mLineLength, point[1] - mCircleRadius, point[0], point[1] + mCircleRadius, mPaint);
                            canvas.drawArc(new RectF(point[0] - mLineLength - mCircleRadius, point[1] - mCircleRadius, point[0] - mLineLength + mCircleRadius, point[1] + mCircleRadius), 90, 180, true, mPaint);
                            break;
                        case 3:
                            canvas.drawArc(new RectF(point[0] - mCircleRadius, point[1] - mLineLength - mCircleRadius, point[0] + mCircleRadius, point[1] - mLineLength + mCircleRadius), 180, 180, true, mPaint);
                            canvas.drawRect(point[0] - mCircleRadius, point[1] - mLineLength, point[0] + mCircleRadius, point[1], mPaint);
                            canvas.drawArc(new RectF(point[0] - mCircleRadius, point[1] - mCircleRadius, point[0] + mCircleRadius, point[1] + mCircleRadius), 0, 180, true, mPaint);
                            break;
                    }
                }
                break;
            case 2://������ת
                canvas.rotate(mCanvasAngle, x, y);
                for (int i = 0; i < points.size(); i++) {
                    mPaint.setColor(mColors[i]);
                    float[] point = points.get(i);
                    canvas.drawCircle(point[0], point[1], mCircleRadius, mPaint);
                }
                break;
            case 3://�㿿������
                for (int i = 0; i < points.size(); i++) {
                    mPaint.setColor(mColors[i]);
                    float[] point = points.get(i);
                    switch (i) {
                        case 0:
                            canvas.drawCircle(point[0] + mPointMove, point[1], mCircleRadius, mPaint);
                            break;
                        case 1:
                            canvas.drawCircle(point[0], point[1] + mPointMove, mCircleRadius, mPaint);
                            break;
                        case 2:
                            canvas.drawCircle(point[0] - mPointMove, point[1], mCircleRadius, mPaint);
                            break;
                        case 3:
                            canvas.drawCircle(point[0], point[1] - mPointMove, mCircleRadius, mPaint);
                            break;
                    }
                }
                break;
        }
    }

    private void drawPointMove() {
        ValueAnimator lineAnim = ValueAnimator.ofInt(0, (int) (lineMax * 0.5), 0);
        lineAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPointMove = (int) animation.getAnimatedValue();
                invalidate();
            }
        });

        lineAnim.setRepeatCount(0);
        lineAnim.setDuration(1000);
        lineAnim.setInterpolator(new LinearInterpolator());
        lineAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                type = 1;
                if(isRun)drawCLC();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        list.add(lineAnim);
        lineAnim.start();
    }

    //��ת����
    private void drawPointRotation() {
        ValueAnimator canvasRotateAnim = ValueAnimator.ofInt(mCanvasAngle + 0, mCanvasAngle + 360);
        canvasRotateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCanvasAngle = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        canvasRotateAnim.setRepeatCount(0);
        canvasRotateAnim.setDuration(1000);
        canvasRotateAnim.setInterpolator(new LinearInterpolator());
        canvasRotateAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                type = 3;//��Բ+��ֱ��+��Բ
                if(isRun)drawPointMove();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        canvasRotateAnim.start();
        list.add(canvasRotateAnim);
    }


    //����Բ������+������+��Բ������
    private void drawCLC() {
        Collection<Animator> animList = new ArrayList<>();

        ValueAnimator lineAnim = ValueAnimator.ofInt(lineMin, lineMax, lineMin);
        lineAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLineLength = (int) animation.getAnimatedValue();
            }
        });

        ValueAnimator canvasRotateAnim = ValueAnimator.ofInt(mCanvasAngle + 0, mCanvasAngle + 360);
        canvasRotateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCanvasAngle = (int) animation.getAnimatedValue();
                invalidate();
            }
        });

        animList.add(canvasRotateAnim);
        animList.add(lineAnim);

        list.add(canvasRotateAnim);
        list.add(lineAnim);

        AnimatorSet animationSet = new AnimatorSet();
        animationSet.playTogether(animList);
        animationSet.setDuration(1500);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                type = 2;
                if(isRun)drawPointRotation();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        list.add(animationSet);
        animationSet.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//      float shortLen = 45;
//      float lengthLen = 150;
		points = new ArrayList<>();
		x = getMeasuredWidth() / 2;
		y = getMeasuredHeight() / 2;
		float shortLen = 15;
		float lengthLen = 50;
		points.add(new float[] { x - lengthLen, y - shortLen });
		points.add(new float[] { x + shortLen, y - lengthLen });
		points.add(new float[] { x + lengthLen, y + shortLen });
		points.add(new float[] { x - shortLen, y + lengthLen });
    }
    private boolean isRun = false ;
    public void start() {
        if(!isRun){
            isRun = true;
            init();
            drawCLC();
        }
    }

    List<Animator> list = new ArrayList<>();

    public void stop() {
        if(isRun){
            isRun = false ;
            for (Animator animator : list) {
                animator.cancel();
            }
            list.clear();
        }
    }



}
