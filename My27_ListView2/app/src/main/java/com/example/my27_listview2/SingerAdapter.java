package com.example.my27_listview2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {
    private static final String TAG = "Main : SingerAdapter";
    private Context context;
    private ArrayList<SingerDTO> dtos;
    Dialog dialog;
    Point size;
    private LayoutInflater inflater;

    public SingerAdapter(Context context, ArrayList<SingerDTO> dtos, Point size) {
        this.context = context;
        this.dtos = dtos;
        this.size = size;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addDTO(SingerDTO dto){
        dtos.add(dto);
    }

    public void removeDTOs(){
        dtos.clear();
    }

    @Override
    public int getCount() {
        return dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: "+position);
        SingerViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.singerview, parent,false);
            viewHolder = new SingerViewHolder();
            viewHolder.tvName = convertView.findViewById((R.id.tvName));
            viewHolder.tvMobile = convertView.findViewById(R.id.tvMobile);
            viewHolder.ivImage = convertView.findViewById(R.id.ivImage);
            viewHolder.ivTrash = convertView.findViewById(R.id.ivTrash);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (SingerViewHolder) convertView.getTag();
        }
        SingerDTO dto = dtos.get(position);
        String name = dto.getName();
        String mobile = dto.getMobile();
        int resImage = dto.getResId();
        viewHolder.tvName.setText(name);
        viewHolder.tvMobile.setText(mobile);
        viewHolder.ivImage.setImageResource(resImage);

        viewHolder.ivTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dtos.remove(position);
                notifyDataSetChanged();
            }
        });

        viewHolder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "선택 : "+position+"\n이름 : "+name, Toast.LENGTH_SHORT).show();
                popUpImgXml(dto);
                popUpImg(resImage);

            }
        });

        return convertView;
    }

    public void popUpImgXml(SingerDTO dto){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.popupimg,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.tvName2);
        TextView tvMobile = view.findViewById(R.id.tvMobile2);

        imageView.setImageResource(dto.getResId());
        tvName.setText(dto.getName());
        tvMobile.setText(dto.getMobile());
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

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.x = (int) Math.round(sizeX * 0.005);
        params.y = (int) Math.round(sizeY * 0.01);
        params.width = (int) Math.round(sizeX * 0.9);
        params.height = (int) Math.round(sizeY * 0.9);
        dialog.getWindow().setAttributes(params);
    }

    public void popUpImg(int resImage){
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(resImage);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("이미지 띄우기").setView(imageView);

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
    }

    public class SingerViewHolder{
        public ImageView ivImage, ivTrash;
        public TextView tvName, tvMobile;
    }

}
