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

public class Fragment2 extends Fragment {
    Person person2;
    Button button2;
    TextView textView2;
    MainActivity activity;
    private String sendData;
    private String receiveData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        button2 = viewGroup.findViewById(R.id.btn2);
        textView2 = viewGroup.findViewById(R.id.textView2);

        if(activity.mBundle !=null){
            Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            Person person1 = (Person) bundle.getSerializable("person1");
            String name = person1.getName();
            int age = person1.getAge();
            textView2.setText(receiveData+"\n");
            textView2.append("name : "+name+"\nage : "+age);

            activity.mBundle=null;
        }


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData",sendData);
                bundle.putSerializable("person2", person2);
                bundle.putInt("index",1);

                activity.fragBtnClicked(bundle);
                TabLayout.Tab tab = activity.tabs.getTabAt(2);
                tab.select();
            }
        });
        return viewGroup;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
        sendData = "프래그먼트2에서 보낸 데이터입니다.";
        person2 = new Person("LEE", 27);
        receiveData = "";
    }
}
