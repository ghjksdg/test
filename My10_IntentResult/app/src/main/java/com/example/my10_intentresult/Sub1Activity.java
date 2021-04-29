package com.example.my10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sub1Activity extends AppCompatActivity {

    private static final String TAG = "main:Sub1Activity";
    Button btnSub;
    TextView tvSub;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        btnSub = findViewById(R.id.btnsub1);
        tvSub = findViewById(R.id.tvSub);
        intent = getIntent();
        if(intent != null){
            String id = intent.getStringExtra("id");
            int pw = intent.getIntExtra("pw", 0);
            PersonDTO dto = (PersonDTO) intent.getSerializableExtra("personDTO1");
            Log.d(TAG, "onCreate: id : "+id+", pw : "+pw);
            tvSub.setText("id : "+id+",\n pw : "+pw);
            tvSub.append("\nname : "+dto.getName()+",\n pw : "+dto.getPw());
        }
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent();
                reIntent.putExtra("key", tvSub.getText()+" \n ㅋㅋㅋㅋ");
                setResult(RESULT_OK, reIntent);
                finish();
            }
        });
    }
}