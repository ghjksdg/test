package com.example.my18fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    SubFragment subFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        subFragment = new SubFragment();
        mainFragment = new MainFragment();
        onFragmentChange(2);
    }

    public void onFragmentChange(int state){
        if (state == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.contains1, subFragment).commit();
        }else if(state == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.contains1, mainFragment).commit();
        }
    }
}