package com.example.my00_list;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<String> dtos;
    Point size;
    Dialog dialog;
    public ListAdapter(ArrayList<String> dtos, Context context, Point size) {
        this.dtos = dtos;
        this.context = context;
        this.size = size;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String dto = dtos.get(position);
        holder.setDto(dto);
        holder.inImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDto(position);
                notifyDataSetChanged();
            }
        });
        holder.rightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "선택 : "+position+"\n이름 : "+dto, Toast.LENGTH_SHORT).show();
                popUpImgXml(dto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }
    public void addDTO(String dto){
        dtos.add(dto);
    }
    public void removeDto(int position){
        dtos.remove(position);
    }
    public void popUpImgXml(String dto){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.popupimg,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.tvName2);
        TextView tvMobile = view.findViewById(R.id.tvMobile2);

        imageView.setImageResource(Integer.parseInt(dto));
        tvName.setText(dto);
        tvMobile.setText(dto);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("이미지 띄우기").setView(view);

        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dialog != null){
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.create();
        dialog.show();
        int sizeX = size.x;
        int sizeY = size.y;
        ConstraintLayout.LayoutParams imageParams;
        imageParams = (ConstraintLayout.LayoutParams) dialog.
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.x = (int) Math.round(sizeX * 0.005);
        imageParams.width = sizeX;
        params.y = (int) Math.round(sizeY * 0.01);
        imageParams.height = (int) Math.round(sizeY * 0.9);
        params.width = (int) Math.round(sizeX * 0.9);
        params.height = (int) Math.round(sizeY * 0.9);
        dialog.getWindow().setAttributes(params);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView list_Text;
        Button list_button;
        ImageView rightImage, inImage;

        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list_Text = itemView.findViewById(R.id.list_Text);
            list_button = itemView.findViewById(R.id.list_button);
            rightImage = itemView.findViewById(R.id.rightImage);
            inImage = itemView.findViewById(R.id.inImage);
        }

        public void setDto(String dto){
            list_Text.setText(dto);
            list_button.setText(Integer.toString(dtos.size()));
            rightImage.setImageResource(Integer.parseInt(dto));
            inImage.setImageResource(Integer.parseInt(dto));
        }
    }
}
