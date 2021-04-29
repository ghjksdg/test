package com.example.my15_touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout1, linearLayout2;
    TextView textView;
    ScrollView scrollView;
    GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);
        linearLayout1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();
                if(action == MotionEvent.ACTION_DOWN){
                    appendText("마우스 눌림"+curX+", "+curY);
                } else if(action==MotionEvent.ACTION_MOVE){
                    appendText("마우스 움직임"+curX+", "+curY);
                }else if(action==MotionEvent.ACTION_UP){
                    appendText("마우스 올림"+curX+", "+curY);
                }
                return true;
            }
        });
        linearLayout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);

                return true;
            }
        });
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                appendText("onDown() 호출됨 : ");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

                appendText("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                appendText("onSingleTapUp() 호출됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                appendText("onScroll() 호출됨 : "+distanceX+", "+distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                appendText("onLongPress() 호출됨");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                appendText("onFling() 호출됨 : "+velocityX+", "+velocityY);
                return true;
            }

        });
    }

    private void appendText(String s) {
        textView.append(s+"\n");
        scrollView.fullScroll(View.FOCUS_DOWN);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            appendText("시스템에서 [BACK]버튼이 눌렸습니다.");
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
            appendText("시스템에서 [VOLUME_UP]버튼이 눌렸습니다.");
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            appendText("시스템에서 [VOLUME_DOWN]버튼이 눌렸습니다.");
            return true;
        }

        return false;
    }
}