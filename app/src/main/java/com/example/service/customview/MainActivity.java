package com.example.service.customview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text = (EditText)findViewById(R.id.edit_text);

        edit_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch (View v, MotionEvent event) {
                // et.getCompoundDrawables()得到一个长度为4的数组，分别表示左右上下四张图片
                Drawable drawable = edit_text.getCompoundDrawables()[2];
                //如果右边没有图片，不再处理
                if(drawable == null) {
                    return false;
                }
                // 如果不是按下事件，不在处理
                if(event.getAction() != MotionEvent.ACTION_UP) {
                    return false;
                }
                if(event.getX() > edit_text.getWidth() - edit_text.getPaddingRight()
                        - drawable.getIntrinsicWidth()) {
                    edit_text.setText("");
                }
                return false;
            }
        });
    }


}
