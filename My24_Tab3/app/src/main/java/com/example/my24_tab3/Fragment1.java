package com.example.my24_tab3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Fragment1 extends Fragment {
    Person person1;
    Button button1;
    TextView textView1;
    MainActivity activity;
    private String sendData;
    private String receiveData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        button1 = viewGroup.findViewById(R.id.btn1);
        textView1 = viewGroup.findViewById(R.id.textView1);


        if(activity.mBundle !=null){
            Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            Person person3 = (Person) bundle.getSerializable("person3");
            String name = person3.getName();
            int age = person3.getAge();
            textView1.setText(receiveData+"\n");
            textView1.append("name : "+name+"\nage : "+age);

            activity.mBundle=null;
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData",sendData);
                bundle.putSerializable("person1", person1);
                bundle.putInt("index",0);

                activity.fragBtnClicked(bundle);
                TabLayout.Tab tab = activity.tabs.getTabAt(1);
                tab.select();
            }
        });
        return viewGroup;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
        sendData = "프래그먼트1에서 보낸 데이터입니다.";
        person1 = new Person("HONG", 25);
        receiveData = "";
    }
}
