package com.example.my19fragment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment;
    ViewerFragment viewerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewerFragment = (ViewerFragment) getSupportFragmentManager().findFragmentById(R.id.viewerFragment);
        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);

    }

    public void onImageSelected(int res){
        viewerFragment.imgChange(res);
    }
}