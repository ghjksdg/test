package com.example.my04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_Change;
    ImageView dream1, dream2, dream3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Change = findViewById(R.id.btnChange);
        dream1 = findViewById(R.id.imageView1);
        dream2 = findViewById(R.id.imageView2);
        dream3 = findViewById(R.id.imageView3);
        btn_Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dream1.setVisibility((dream1.getVisibility()+4)%12);
                dream2.setVisibility((dream2.getVisibility()+4)%12);
                dream3.setVisibility((dream3.getVisibility()+4)%12);
            }
        });
    }
}