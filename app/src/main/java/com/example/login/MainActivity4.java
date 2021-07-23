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

public class MainActivity4 extends AppCompatActivity {
    ArrayList<Truyen> truyen = new ArrayList<Truyen>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh4);
        Anhxa();
        ConTrolbtn();
    }
    private void Anhxa(){
        int  id = getIntent().getExtras().getInt("I");
        ImageView imghinh1 = (ImageView)findViewById(R.id.imgdoc) ;
        Cursor datatruyen = MainActivity.DB.rawQuery("SELECT * FROM truyen",null);
        while (datatruyen.moveToNext()) {
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
    }
    private void ConTrolbtn(){
        int  id = getIntent().getExtras().getInt("I");
        ImageView imghinh1 = (ImageView)findViewById(R.id.imgdoc) ;
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Truyen TruyenABC = truyen.get(id);
        Bitmap bitmap = BitmapFactory.decodeByteArray(TruyenABC.getHinh1(),0,TruyenABC.getHinh().length);
        imghinh1.setImageBitmap(bitmap);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                Bitmap bitmap = BitmapFactory.decodeByteArray(TruyenABC.getHinh1(),0,TruyenABC.getHinh().length);
                imghinh1.setImageBitmap(bitmap);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                Bitmap bitmap = BitmapFactory.decodeByteArray(TruyenABC.getHinh2(),0,TruyenABC.getHinh().length);
                imghinh1.setImageBitmap(bitmap);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                Bitmap bitmap = BitmapFactory.decodeByteArray(TruyenABC.getHinh3(),0,TruyenABC.getHinh().length);
                imghinh1.setImageBitmap(bitmap);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen TruyenABC = truyen.get(id);
                Bitmap bitmap = BitmapFactory.decodeByteArray(TruyenABC.getHinh4(),0,TruyenABC.getHinh().length);
                imghinh1.setImageBitmap(bitmap);

            }
        });

    }
}