package com.example.login;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ActivityThem extends AppCompatActivity {
    EditText tensach,theloai,tacgia,sochuong,noidung;
    Button btnanhbia,btnthem;
    final int REQUEST_CODE_GALLERY = 999;
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
        btnthem=(Button)findViewById(R.id.btnThem);
        img = (ImageView)findViewById(R.id.imgbia);
        btnanhbia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        ActivityThem.this ,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_GALLERY);
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tensach.getText().length() != 0 && theloai.getText().length() != 0 && tacgia.getText().length() != 0 && sochuong.getText().length() != 0 && noidung.getText().length() != 0 ){
                    MainActivity.DB.execSQL("INSERT INTO truyen values(null,'"+tensach.getText().toString()+"','"+theloai.getText().toString()+"','"+imageViewToByte(img)+"','"+tacgia.getText().toString()+"','"+sochuong.getText().toString()+"','"+noidung.getText().toString()+"','"+imageViewToByte(img)+"','"+imageViewToByte(img)+"','"+imageViewToByte(img)+"','"+imageViewToByte(img)+"')");
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

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if (grantResults.length  > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent , REQUEST_CODE_GALLERY);
            }

            else {
                Toast.makeText(getApplicationContext(), "You don't have permisstion to access file location! " , Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();


            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}