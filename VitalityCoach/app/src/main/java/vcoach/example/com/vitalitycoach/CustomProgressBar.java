package vcoach.example.com.vitalitycoach;

/**
 * Created by ASHWINI2 on 15/07/2017.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class CustomProgressBar extends View {


    private int max = 100;

    private int progress;

    private Path path = new Path();

    int color = 0xff44C8E5;

    private Paint paint;

    private Paint mPaintProgress;

    private RectF mRectF;

    private Paint textPaint;

    private String text = "0%";

    private final Rect textBounds = new Rect();

    private int centerY;

    private int centerX;

    private int swipeAndgle = 0;


    public CustomProgressBar(Context context) {
        super(context);
        initUI();
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI();
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initUI();
    }

    private void initUI() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(UiUtils.dpToPx(getContext(), 1));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);


        mPaintProgress = new Paint();
        mPaintProgress.setAntiAlias(true);
        mPaintProgress.setStyle(Paint.Style.STROKE);
        mPaintProgress.setStrokeWidth(UiUtils.dpToPx(getContext(), 9));
        mPaintProgress.setColor(color);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(color);
        textPaint.setStrokeWidth(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight = MeasureSpec.getSize(heightMeasureSpec);

        int radius = (Math.min(viewWidth, viewHeight) - UiUtils.dpToPx(getContext(), 2)) / 2;

        path.reset();

        centerX = viewWidth / 2;
        centerY = viewHeight / 2;
        path.addCircle(centerX, centerY, radius, Path.Direction.CW);

        int smallCirclRadius = radius - UiUtils.dpToPx(getContext(), 7);
        path.addCircle(centerX, centerY, smallCirclRadius, Path.Direction.CW);
        smallCirclRadius += UiUtils.dpToPx(getContext(), 4);

        mRectF = new RectF(centerX - smallCirclRadius, centerY - smallCirclRadius, centerX + smallCirclRadius, centerY + smallCirclRadius);

        textPaint.setTextSize(radius * 0.5f);
    }


    @Override
    protected void onDraw(Canvas canvas) {


        super.onDraw(canvas);

        canvas.drawPath(path, paint);

        canvas.drawArc(mRectF, 270, swipeAndgle, false, mPaintProgress);

        drawTextCentred(canvas);

    }

    public void drawTextCentred(Canvas canvas) {

        textPaint.getTextBounds(text, 0, text.length(), textBounds);

        canvas.drawText(text, centerX - textBounds.exactCenterX(), centerY - textBounds.exactCenterY(), textPaint);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setProgress(int progress) {
        this.progress = progress;

        int percentage = progress * 100 / max;

        swipeAndgle = percentage * 360 / 100;

        text = percentage + "%";

        invalidate();
    }

    public void setColor(int color) {
        this.color = color;
    }
}