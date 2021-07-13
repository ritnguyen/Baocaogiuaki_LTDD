package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TruyenAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Truyen> truyenList;

    public TruyenAdapter(Context context, int layout, List<Truyen> truyenList) {
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //ánh xạ view
        TextView txtTentruyen = (TextView) view.findViewById(R.id.txtTentruyen);
        TextView txtTheLoai = (TextView) view.findViewById(R.id.txtTheLoai);
        ImageView imghinh = (ImageView) view.findViewById(R.id.imgdoc);
        //gán giá trị
        Truyen truyen = truyenList.get(i);
        txtTentruyen.setText(truyen.getTentruyen());
        txtTheLoai.setText(truyen.getTheloai());
        imghinh.setImageResource(truyen.getHinh());
        return view;
    }
}
