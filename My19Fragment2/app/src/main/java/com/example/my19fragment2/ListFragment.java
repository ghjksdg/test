package com.example.my19fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.listfragment,container,false);
        activity = (MainActivity) getActivity();
        view.findViewById(R.id.listImage1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageSelected(R.drawable.finger);
            }
        });
        view.findViewById(R.id.listImage2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageSelected(R.drawable.finger_pressed);
            }
        });
        return view;
    }
}
