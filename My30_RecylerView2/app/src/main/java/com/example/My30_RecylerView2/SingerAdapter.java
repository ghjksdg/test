package com.example.My30_RecylerView2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHolder> implements OnSingerItemClickListener{
    private static final String TAG = "Main : SingerAdapter";

    OnSingerItemClickListener listener;

    ArrayList<SingerDTO> dtos;
    Context context;
    LayoutInflater inflater;

    public SingerAdapter(ArrayList<SingerDTO> dtos, Context context) {
        this.dtos = dtos;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.singerview, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        SingerDTO dto = dtos.get(position);
        holder.setDto(dto);

        holder.ivTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDto(position);
                notifyDataSetChanged();
            }
        });
//
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "선택 : "+position+"\n이름 : "+dto.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }

    public void addDTO(SingerDTO dto){
        dtos.add(dto);
    }

    public void removeDto(int position){
        dtos.remove(position);
    }

    public void setOnItemClickListener(OnSingerItemClickListener listener){
        this.listener = listener;
    }

    public SingerDTO getItem(int position){
        return dtos.get(position);
    }

    @Override
    public void onItemClick(ViewHolder holderm, View view, int position) {
        if(listener != null){
            listener.onItemClick(holderm, view, position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvMobile;
        ImageView ivImage, ivTrash;
        CardView card;

        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView, OnSingerItemClickListener listener) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            card = itemView.findViewById(R.id.card);
            tvName = itemView.findViewById(R.id.tvName);
            tvMobile = itemView.findViewById(R.id.tvMobile);
            ivImage = itemView.findViewById(R.id.ivImage);
            ivTrash = itemView.findViewById(R.id.ivTrash);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });

        }

        public void setDto(SingerDTO dto){
            tvName.setText(dto.getName());
            tvMobile.setText(dto.getMobile());
            ivImage.setImageResource(dto.getResId());
            ivTrash.setImageResource(R.drawable.super_trash);
        }
    }
}
