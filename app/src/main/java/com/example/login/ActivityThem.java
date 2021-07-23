package com.example.login;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class ActivityThem extends AppCompatActivity {
    EditText tensach,theloai,tacgia,sochuong,noidung;
    Button btnanhbia,btnanhnd,btnthem;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhthem);
        Anhxa();
    }
    public void Anhxa(){
        tensach = (EditText) findViewById(R.id.edittensach);
        theloai = (EditText) findViewById(R.id.edittheloai);
        tacgia = (EditText) findViewById(R.id.edittacia);
        sochuong = (EditText) findViewById(R.id.editsochuong);
        noidung = (EditText) findViewById(R.id.editnoidung);
        btnanhbia=(Button)findViewById(R.id.btnanhbia);
        btnanhnd=(Button)findViewById(R.id.btnanhnd);
        btnthem=(Button)findViewById(R.id.btnThem);
        img = (ImageView)findViewById(R.id.img);
        btnanhbia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tensach.getText().length() != 0 && theloai.getText().length() != 0 && tacgia.getText().length() != 0 && sochuong.getText().length() != 0 && noidung.getText().length() != 0 ){
                    MainActivity.DB.execSQL("INSERT INTO truyen values(null,'"+tensach.getText().toString()+"','"+theloai.getText().toString()+"',null,'"+tacgia.getText().toString()+"','"+sochuong.getText().toString()+"','"+noidung.getText().toString()+"',null,null,null,null)");
                    Toast.makeText(ActivityThem.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ActivityThem.this,MainActivity2.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(ActivityThem.this,"Không được để trống dữ liệu",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    img.setImageURI(uri);
                }
            });
    private byte[] imageViewToByte(ImageView img){
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArray);
        byte[]hinh = byteArray.toByteArray();
        return hinh;
    }
}