package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TruyenAdapter extends BaseAdapter {
    private MainActivity2 context;
    private int layout;
    private List<Truyen> truyenList;

    public TruyenAdapter(MainActivity2 context, int layout, List<Truyen> truyenList) {
        this.context = context;
        this.layout = layout;
        this.truyenList = truyenList;
    }

    @Override
    public int getCount() {
        return truyenList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private  class ViewHolder{
        TextView txtTentruyen;
        TextView txtTheLoai ;
        ImageView imghinh,delete,edit;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtTentruyen = (TextView) view.findViewById(R.id.txtTentruyen);
            holder.txtTheLoai = (TextView) view.findViewById(R.id.txtTheLoai);
            holder.imghinh = (ImageView) view.findViewById(R.id.imgdoc);
            holder.delete = (ImageView) view.findViewById(R.id.btndelete);
            holder.edit = (ImageView) view.findViewById(R.id.btnedit);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //gán giá trị
        Truyen truyen = truyenList.get(i);
        holder.txtTentruyen.setText(truyen.getTentruyen());
        holder.txtTheLoai.setText(truyen.getTheloai());
        byte[] userImage = truyen.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(userImage,0,userImage.length);
        holder.imghinh.setImageBitmap(bitmap);
        //bắt dự kiên xóa sửa
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",truyen.getId());
                bundle.putString("truyen",truyen.getTentruyen());
                bundle.putString("theloai",truyen.getTheloai());
                bundle.putString("tacgia",truyen.getTacgia());
                bundle.putString("sochuong",truyen.getSochuong());
                bundle.putString("noidung",truyen.getNoiDung());
                bundle.putByteArray("Hinh", truyen.getHinh());
                Intent intent = new Intent(context,ActivitySua.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoa(truyen.getTentruyen(),truyen.getId());
            }
        });
        return view;
    }
}
