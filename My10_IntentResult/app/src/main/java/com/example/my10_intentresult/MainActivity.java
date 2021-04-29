package com.example.my10_intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main:MainActivity";
    Button btnMain;
    TextView tvMain;
    final int Reqcode = 1004;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain = findViewById(R.id.button);
        tvMain = findViewById(R.id.tvMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                PersonDTO dto = new PersonDTO("pack", 4321);
                intent.putExtra("id", "KIM");
                intent.putExtra("pw", 1234);
                intent.putExtra("personDTO1", dto);
                startActivityForResult(intent, Reqcode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Reqcode){
            String key = data.getStringExtra("key");
            Log.d(TAG, key);
            tvMain.setText(key);
        }else if (requestCode == 1002){

        }
    }
}