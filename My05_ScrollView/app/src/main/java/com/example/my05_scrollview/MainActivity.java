package com.example.my05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnImg;
    ImageView imageView1;
    int img = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnImg = findViewById(R.id.btnImg);
        imageView1 = findViewById(R.id.imageView1);
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img = img==0?setImg1():setImg2();
            }
        });
    }
    private int setImg1(){
        imageView1.setImageResource(R.drawable.image01);
        return 1;
    }
    private int setImg2(){
        imageView1.setImageResource(R.drawable.image02);
        return 0;
    }
}