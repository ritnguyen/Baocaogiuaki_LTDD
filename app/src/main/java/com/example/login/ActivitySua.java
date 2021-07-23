package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivitySua extends AppCompatActivity {
    EditText tensach,theloai,tacgia,sochuong,noidung;
    Button btnanhbia,btnanhnd,btnsua;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhsua);
        Anhxa();
    }
    private void Anhxa(){
        //nhận dữ liệu
        int  id = getIntent().getExtras().getInt("id");
        String tentruyen1 = getIntent().getExtras().getString("truyen");
        String theloai1 = getIntent().getExtras().getString("theloai");
        String tacgia1 = getIntent().getExtras().getString("tacgia");
        String sochuong1 = getIntent().getExtras().getString("sochuong");
        String noidung1 = getIntent().getExtras().getString("noidung");
        //ánh xạ
        tensach = (EditText) findViewById(R.id.edittensach);
        theloai = (EditText) findViewById(R.id.edittheloai);
        tacgia = (EditText) findViewById(R.id.edittacia);
        sochuong = (EditText) findViewById(R.id.editsochuong);
        noidung = (EditText) findViewById(R.id.editnoidung);
        btnanhbia=(Button)findViewById(R.id.btnanhbia);
        btnanhnd=(Button)findViewById(R.id.btnanhnd);
        btnsua=(Button)findViewById(R.id.btnSua);
        img = (ImageView)findViewById(R.id.img);
        //gánh giá trị
        tensach.setText(tentruyen1);
        theloai.setText(theloai1);
        tacgia.setText(tacgia1);
        sochuong.setText(sochuong1);
        noidung.setText(noidung1);

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tensach.getText().length() != 0 && theloai.getText().length() != 0 && tacgia.getText().length() != 0 && sochuong.getText().length() != 0 && noidung.getText().length() != 0 ){
                    MainActivity.DB.execSQL("UPDATE truyen SET TenTruyen ='"+tensach.getText().toString()+"',TheLoai ='"+theloai.getText().toString()+"',TacGia ='"+tacgia.getText().toString()+"',SoChuong ='"+sochuong.getText().toString()+"',NoiDung ='"+noidung.getText().toString()+"' Where Id = '"+id+"'");
                    Toast.makeText(ActivitySua.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ActivitySua.this,MainActivity2.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(ActivitySua.this,"Không được để trống dữ liệu",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}