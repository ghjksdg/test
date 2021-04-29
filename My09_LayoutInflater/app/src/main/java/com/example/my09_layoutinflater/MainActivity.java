package com.example.my09_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1, btnsub1, btnsub2;
    LinearLayout linear;
    RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear =findViewById(R.id.linear1);
        relative = findViewById(R.id.relative);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                layoutInflater.inflate(R.layout.sub1_layout, linear, true);
                layoutInflater.inflate(R.layout.sub2_layout, relative, true);
                btnsub1 = linear.findViewById(R.id.sub1_button);
                btnsub2 = relative.findViewById(R.id.btnsub2);
                btnsub1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "button Linear 클릭", Toast.LENGTH_SHORT).show();
                    }
                });
                btnsub2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "button relative 클릭", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}