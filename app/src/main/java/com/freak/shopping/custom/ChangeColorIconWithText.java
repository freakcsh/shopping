package com.freak.shopping.custom;

/**
 * Created by thinkpad on 2016/7/24.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.freak.shopping.R;

public class ChangeColorIconWithText extends View
{

    private int mColor =Color.parseColor("#ffdd00");
    private Bitmap mIconBitmap;
    private String mText = "购物";
    private int mTextSize = (int) TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics());

    private Canvas mCanvas;
    private Bitmap mBitmap;
    private Paint mPaint;

    private float mAlpha;

    private Rect mIconRect;
    private Rect mTextBound;
    private Paint mTextPaint;

    public ChangeColorIconWithText(Context context)
    {
        this(context, null);
    }

    public ChangeColorIconWithText(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    /**
     * 获取自定义属性的值
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChangeColorIconWithText(Context context, AttributeSet attrs,
                                   int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ChangeColorIconWithText);

        int n = a.getIndexCount();

        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.ChangeColorIconWithText_icon:
                    BitmapDrawable drawable = (BitmapDrawable) a.getDrawable(attr);
                    mIconBitmap = drawable.getBitmap();
                    break;
                case R.styleable.ChangeColorIconWithText_color:
                    mColor = a.getColor(attr, Color.parseColor("#ffdd00"));
                    break;
                case R.styleable.ChangeColorIconWithText_text:
                    mText = a.getString(attr);
                    break;
                case R.styleable.ChangeColorIconWithText_text_size:
                    mTextSize = (int) a.getDimension(attr, TypedValue
                            .applyDimension(TypedValue.COMPLEX_UNIT_SP, 12,
                                    getResources().getDisplayMetrics()));
                    break;
            }

        }

        a.recycle();

        mTextBound = new Rect();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(Color.parseColor("#ffdd00"));
        mTextPaint.getTextBounds(mText, 0, mText.length(), mTextBound);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int iconWidth = Math.min(getMeasuredWidth() - getPaddingLeft()
                - getPaddingRight(), getMeasuredHeight() - getPaddingTop()
                - getPaddingBottom() - mTextBound.height());

        int left = getMeasuredWidth() / 2 - iconWidth / 2;
        int top = getMeasuredHeight() / 2 - (mTextBound.height() + iconWidth)
                / 2;
          /*
        	Rect（int left，int top，int right，int bottom）
            创建一个具有指定坐标的新矩形。
         */
        mIconRect = new Rect(left, top, left + iconWidth, top + iconWidth);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
           /*
        drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint)
       绘制指定的位图，自动缩放/翻译以填充目标矩形。如果源矩形不为空，则指定要绘制的位图的子集。
        注意：如果paint包含一个maskfilter，该掩码可以生成超出位图原始宽度/高度的掩码（例如BlurMaskFilter），
        那么位图将被绘制为使用CLAMP模式的着色器。因此，原始宽度/高度之外的颜色将被复制的边缘颜色。
        此函数忽略与位图关联的密度。这是因为源和目标矩形坐标空间处于它们各自的密度，所以必须已经具有适当的缩放因子。
        参数
        位图	要绘制的位图
        SRC	可能为null。要绘制的位图的子集
        DST	位图将被缩放/翻译以适应的矩形
        涂料	可能为null。油漆用来绘制位图
         */
        canvas.drawBitmap(mIconBitmap, null, mIconRect, null);
        //设置透明度
        int alpha = (int) Math.ceil(255 * mAlpha);

        // 内存去准备mBitmap , setAlpha , 纯色 ，xfermode ， 图标
        setupTargetBitmap(alpha);
        // 1、绘制原文本 ； 2、绘制变色的文本
        drawSourceText(canvas, alpha);
        drawTargetText(canvas, alpha);
  /*
        public void drawBitmap （Bitmap bitmap，float left，float top，Paint paint）
        使用由当前矩阵转换的指定绘制，绘制指定位图，其顶/左角为（x，y）。
        注意：如果paint包含一个maskfilter，该掩码可以生成超出位图原始宽度/高度的掩码（例如BlurMaskFilter），
        那么位图将被绘制为使用CLAMP模式的着色器。因此，原始宽度/高度之外的颜色将被复制的边缘颜色。
        如果位图和画布具有不同的密度，则此功能将自动缩放位图以与画布相同的浓度绘制。
        参数
        位图	要绘制的位图
        剩下	绘制位图左侧的位置
        最佳	正在绘制位图的顶端的位置
        涂料	用于绘制位图的绘图（可能为null）
         */
        canvas.drawBitmap(mBitmap, 0, 0, null);

    }

    /**
     * 绘制变色的文本
     *
     * @param canvas
     * @param alpha
     */
    private void drawTargetText(Canvas canvas, int alpha)
    {
        mTextPaint.setColor(Color.parseColor("#ffdd00"));
        mTextPaint.setAlpha(alpha);
        int x = getMeasuredWidth() / 2 - mTextBound.width() / 2;
        int y = mIconRect.bottom + mTextBound.height();
        canvas.drawText(mText, x, y, mTextPaint);

    }

    /**
     * 绘制原文本
     *
     * @param canvas
     * @param alpha
     */
    private void drawSourceText(Canvas canvas, int alpha)
    {
        mTextPaint.setColor(0xff333333);
        mTextPaint.setAlpha(255 - alpha);
        int x = getMeasuredWidth() / 2 - mTextBound.width() / 2;
        int y = mIconRect.bottom + mTextBound.height();
        canvas.drawText(mText, x, y, mTextPaint);

    }

    /**
     * 在内存中绘制可变色的Icon
     */
    private void setupTargetBitmap(int alpha)
    {
          /*
            createBitmap（int width，int height， Bitmap.Config config）
        返回具有指定宽度和高度的可变位图。
         */
        mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
                Config.ARGB_8888);
        //初始化画布对象
        mCanvas = new Canvas(mBitmap);
        mPaint = new Paint();
        //设置颜色
        mPaint.setColor(Color.parseColor("#ffdd00"));
          /*
        setAntiAlias（boolean aa）
         对于setFlags（）的帮助器，设置或清除ANTI_ALIAS_FLAG位AntiAliasing可以平滑正在绘制的边缘，但对形状的内部没有影响。
         */
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
         /*
        	setAlpha（int a）
            帮助setColor（），它只分配颜色的alpha值，使其r，g，b值保持不变。
         */
        mPaint.setAlpha(alpha);
         /*
        	drawRect（ RectF rect，油漆）
            使用指定的绘图绘制指定的Rect。
         */
        mCanvas.drawRect(mIconRect, mPaint);
         /*
        setXfermode（ Xfermode xfermode）
        设置或清除xfermode对象。
         */
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setAlpha(255);
        mCanvas.drawBitmap(mIconBitmap, null, mIconRect, mPaint);
    }

    private static final String INSTANCE_STATUS = "instance_status";
    private static final String STATUS_ALPHA = "status_alpha";

    @Override
    protected Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATUS, super.onSaveInstanceState());
        bundle.putFloat(STATUS_ALPHA, mAlpha);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state)
    {
        if (state instanceof Bundle)
        {
            Bundle bundle = (Bundle) state;
            mAlpha = bundle.getFloat(STATUS_ALPHA);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATUS));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public void setIconAlpha(float alpha)
    {
        this.mAlpha = alpha;
        invalidateView();
    }

    /**
     * 重绘
     */
    private void invalidateView()
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            invalidate();
        } else
        {
            postInvalidate();
        }
    }

}
