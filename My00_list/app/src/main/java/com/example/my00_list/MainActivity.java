package com.example.my00_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ListAdapter adapter;
    ArrayList<String> dtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dtos = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        Point size = getDeviceSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ListAdapter(dtos,MainActivity.this, size);
        //int res = R.color.black;
        int res = R.drawable.singer1;
        int res2 = R.drawable.singer1;
        int count = 0;
        adapter.addDTO(Integer.toString(R.drawable.singer1));
        adapter.addDTO(Integer.toString(R.drawable.singer2));
        adapter.addDTO(Integer.toString(R.drawable.singer3));
        adapter.addDTO(Integer.toString(R.drawable.singer4));
        adapter.addDTO(Integer.toString(R.drawable.singer5));
        adapter.addDTO(Integer.toString(R.drawable.super_trash));
        adapter.addDTO(Integer.toString(R.drawable.trash));
        adapter.addDTO(Integer.toString(R.drawable.ic_launcher_background));
        adapter.addDTO(Integer.toString(R.drawable.ic_launcher_foreground));
        adapter.addDTO(Integer.toString(R.color.black));
        while(true){
            try {
                if (count++ > 200000){
                    break;
                }

                adapter.addDTO(Integer.toString(res++));
//                if(res-res2>6){
//                    res = res2;
//                }
            }catch (Exception e){
                break;
            }
        }
        recyclerView.setAdapter(adapter);
    }




    private Point getDeviceSize() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;

        return size;
    }
}