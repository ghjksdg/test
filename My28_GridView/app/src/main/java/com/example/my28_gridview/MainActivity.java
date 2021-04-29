package com.example.my28_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    GridView gridView;

    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Point size = getDeviceSize();

        dtos = new ArrayList<>();
        btnAdd = findViewById(R.id.btnAdd);
        gridView = findViewById(R.id.gridView);
        getApplicationContext();
        adapter = new SingerAdapter(MainActivity.this, dtos, size);
        adapter.addDTO(new SingerDTO("블랙핑크","010-1111-1111",25, R.drawable.singer1));
        adapter.addDTO(new SingerDTO("걸스데이","010-1111-2222",27, R.drawable.singer2));
        adapter.addDTO(new SingerDTO("방탄소년단","010-1111-3333",22, R.drawable.singer3));
        adapter.addDTO(new SingerDTO("마마무","010-1111-4444",30, R.drawable.singer4));
        adapter.addDTO(new SingerDTO("소녀시대","010-1111-5555",28, R.drawable.singer5));
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerDTO dto = (SingerDTO) adapter.getItem(position);
                Toast.makeText(MainActivity.this, "선택 : "+position+"\n이름 : "+dto.getName()+"\n전화번호 : "+dto.getMobile()+"\n나이 : "+dto.getAge()+"\n이미지 : "+dto.getResId(), Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ((int) Math.floor(Math.random()*5)){
                    case 0:
                        adapter.addDTO(new SingerDTO("블랙핑크","010-1111-1111",25, R.drawable.singer1));
                        break;
                    case 1:
                        adapter.addDTO(new SingerDTO("걸스데이","010-1111-2222",27, R.drawable.singer2));
                        break;
                    case 2 :
                        adapter.addDTO(new SingerDTO("방탄소년단","010-1111-3333",22, R.drawable.singer3));
                        break;
                    case 3:
                        adapter.addDTO(new SingerDTO("마마무","010-1111-4444",30, R.drawable.singer4));
                        break;
                    case 4:
                        adapter.addDTO(new SingerDTO("소녀시대","010-1111-5555",28, R.drawable.singer5));
                        break;
                }
                adapter.notifyDataSetChanged();
            }
        });

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