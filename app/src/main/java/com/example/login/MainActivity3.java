package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<Truyen> truyen ;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh3);
        truyen = new ArrayList<Truyen>();
        Cursor datatruyen = MainActivity.DB.rawQuery("SELECT * FROM truyen",null);
        while (datatruyen.moveToNext()){
            truyen.add(new Truyen(
                    datatruyen.getInt(0),
                    datatruyen.getString(1),
                    datatruyen.getString(2),
                    datatruyen.getBlob(3),
                    datatruyen.getString(4),
                    datatruyen.getString(5),
                    datatruyen.getString(6),
                    datatruyen.getBlob(7),
                    datatruyen.getBlob(8),
                    datatruyen.getBlob(9),
                    datatruyen.getBlob(10)));
        }
        Anhxa();
        Controlbtn();
    }
    private void Anhxa(){
        int  id = getIntent().getExtras().getInt("id");
        TextView tentruyen = (TextView) findViewById(R.id.tentruyen);
        TextView txttentruyen = (TextView)findViewById(R.id.txtTen);
        TextView txttheloai = (TextView)findViewById(R.id.txttheloai);
        TextView txttacgia = (TextView)findViewById(R.id.txttacgia);
        TextView txtsochuong = (TextView)findViewById(R.id.txtsochuong);
        TextView txtnoidung = (TextView)findViewById(R.id.txtnoidung);
        ImageView imghinh = (ImageView)findViewById(R.id.imganh) ;
        Truyen TruyenABC = truyen.get(id);
        tentruyen.setText(TruyenABC.getTentruyen());
        txttentruyen.setText(TruyenABC.getTentruyen());
        txttheloai.setText(TruyenABC.getTheloai());
        txttacgia.setText(TruyenABC.getTacgia());
        txtsochuong.setText(TruyenABC.getSochuong());
        txtnoidung.setText(TruyenABC.getNoiDung());
        Bitmap bitmap = BitmapFactory.decodeByteArray(TruyenABC.getHinh(),0,TruyenABC.getHinh().length);
        imghinh.setImageBitmap(bitmap);

    }
    private void Controlbtn(){
        Button btndoctruyen = (Button)findViewById(R.id.btndoc);
        btndoctruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  id = getIntent().getExtras().getInt("id");
                Bundle bundle = new Bundle();
                bundle.putInt("I", id);
                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}