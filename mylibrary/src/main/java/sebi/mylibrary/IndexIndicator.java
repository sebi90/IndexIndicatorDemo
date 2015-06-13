package sebi.mylibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sebi on 13.06.15.
 */
public class IndexIndicator extends View {

    private int value, maximum;
    private Paint pen, penSelected;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Math.max(0, Math.min(value, maximum-1));
        invalidate();

        if(mOnValueChangedListener != null)
        {
            mOnValueChangedListener.onValueChanged(this, this.value);
        }

    }

    public int getMaximum() {
        return maximum-1;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
        invalidate();
    }


    private void setup() {
        value = 0;
        maximum = 5;

        pen = new Paint();
        pen.setColor(Color.BLACK);
        pen.setAntiAlias(true);
        pen.setStyle(Paint.Style.STROKE);
        pen.setStrokeWidth(3);

        penSelected = new Paint();
        penSelected.setColor(Color.CYAN);
        penSelected.setStyle(Paint.Style.FILL);
        penSelected.setAntiAlias(true);
        penSelected.setStrokeWidth(3);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int space = 10;
        final int width = (getWidth() / maximum ) -space;
        final int height = getHeight() - space;



        //draw rectangle
        for (int i = 0; i < maximum; i++) {
            if(i == value)
            {
                canvas.drawRect(width  * i + space * (i +1), space, width * (i+1) + space * i, height, penSelected);
            }
            else{
                canvas.drawRect(width  * i + space * (i +1), space, width * (i+1) + space * i, height, pen);
            }
        }

        /*canvas.drawRect(width * i + space * i, 0, width * i+1 + space * i, height, pen);
        canvas.drawRect(width * 1 + space * 1, 0, width * 2 + space * 1, height, pen);
        canvas.drawRect(width * 2 + space * 2, 0, width * 3 + space * 2, height, pen);
        */

    }

    public interface OnValueChangeListener {
        public void onValueChanged(View v, int value);
    }

    private OnValueChangeListener mOnValueChangedListener = null;

    public void setOnValueChangedListener(OnValueChangeListener l)
    {
        mOnValueChangedListener = l;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int DEFAULT_WIDTH = 300;
        final int DEFAULT_HEIGHT = 50;
        int w = widthMeasureSpec;
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            w = DEFAULT_WIDTH;
        }
        int h = heightMeasureSpec;
        if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            h = DEFAULT_HEIGHT;
        }
        setMeasuredDimension(w, h);
    }

    public IndexIndicator(Context context) {
        super(context);
        setup();
    }

    public IndexIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public IndexIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public IndexIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }
}
