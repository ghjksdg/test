package com.example.my26_listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayList<String> list = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selItem = (String) parent.getItemAtPosition(position);
                textView.setText(selItem);
            }
        });




        list.add("날아라");
        list.add("슈뢰딩거");
        list.add("고양이의 저편까지");
        list.add("살아남은 고양이가");
        list.add("너에게 복수하러 올거야");
        list.add("살아남은 고양이들은 전원");
        list.add("양자화를 마음대로 할수가 있어");
        list.add("즉 장애물을 마음대로 통과할수가 있어");
        list.add("");
        list.add("제길! 어떻게 도망치지");
        list.add("아무리 고양이라도");
        list.add("각지지 않은 곳에서는");
        list.add("출연할수 없어");
        list.add("예각을 없애야되");
        list.add("둔각에서는 고양이가 나타날 수 없어!");
        list.add("예각인 물건을 부숴!");
        list.add("부숴져라아아아아아");
        list.add("");
        list.add("");
        list.add("");
        list.add("");



    }
}