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

public class Fragment3 extends Fragment {
    Person person3;
    Button button3;
    TextView textView3;
    MainActivity activity;
    private String sendData;
    private String receiveData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        button3 = viewGroup.findViewById(R.id.btn3);
        textView3 = viewGroup.findViewById(R.id.textView3);

        if(activity.mBundle !=null){
            Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            Person person2 = (Person) bundle.getSerializable("person2");
            String name = person2.getName();
            int age = person2.getAge();
            textView3.setText(receiveData+"\n");
            textView3.append("name : "+name+"\nage : "+age);

            activity.mBundle=null;
        }


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData",sendData);
                bundle.putSerializable("person3", person3);
                bundle.putInt("index",2);

                activity.fragBtnClicked(bundle);
                TabLayout.Tab tab = activity.tabs.getTabAt(0);
                tab.select();
            }
        });
        return viewGroup;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
        sendData = "프래그먼트3에서 보낸 데이터입니다.";
        person3 = new Person("PACK", 29);
        receiveData = "";
    }
}
