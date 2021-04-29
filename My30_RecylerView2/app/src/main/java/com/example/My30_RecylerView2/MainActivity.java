package com.example.My30_RecylerView2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dtos = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new SingerAdapter(dtos,MainActivity.this);
        adapter.addDTO(new SingerDTO("블랙핑크","010-1111-1111",25, R.drawable.singer1));
        adapter.addDTO(new SingerDTO("걸스데이","010-1111-2222",27, R.drawable.singer2));
        adapter.addDTO(new SingerDTO("방탄소년단","010-1111-3333",22, R.drawable.singer3));
        adapter.addDTO(new SingerDTO("마마무","010-1111-4444",30, R.drawable.singer4));
        adapter.addDTO(new SingerDTO("소녀시대","010-1111-5555",28, R.drawable.singer5));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnSingerItemClickListener() {
            @Override
            public void onItemClick(SingerAdapter.ViewHolder holderm, View view, int position) {
                SingerDTO dto = adapter.getItem(position);

                Toast.makeText(MainActivity.this, dto.getMobile(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}