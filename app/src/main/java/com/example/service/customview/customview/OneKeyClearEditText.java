package com.example.service.customview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.example.service.customview.R;

/**
 * Created By HanTe
 */

public class OneKeyClearEditText extends AppCompatEditText{

    private Drawable mClearDrawable;
    private int colorAccent;

    public OneKeyClearEditText (Context context) {
        super(context, null);
    }

    public OneKeyClearEditText (Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.editTextStyle);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OneKeyClearEditText (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme()
                .obtainStyledAttributes(new int[]{R.attr.colorAccent});
        colorAccent = typedArray.getColor(0, 0xFF00FF);
        typedArray.recycle();
        initClearDrawable(context);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initClearDrawable (Context context) {
        mClearDrawable = getCompoundDrawables()[2];// 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(R.drawable.close, context.getTheme());
        }
        DrawableCompat.setTint(mClearDrawable, colorAccent);//设置删除按钮的颜色和TextColor的颜色一致
        mClearDrawable.setBounds(0, 0, (int) getTextSize(), (int) getTextSize());//设置Drawable的宽高和TextSize的大小一致
        setClearIconVisible(true);
    }

    private void setClearIconVisible (boolean b) {
        Drawable right = b ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }
}
