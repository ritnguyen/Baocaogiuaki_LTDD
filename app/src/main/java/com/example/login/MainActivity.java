package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText editUser,editPass;
    Button btnlogin,btndangki;
    CheckBox CheckBox;
    ImageButton btncall,btnweb,btnfb;
    String username,password;
    public ArrayList<User> user = new ArrayList<User>();
    public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh1);
        Anhxa();
        ControlBtn();
    }
    private void Anhxa(){
                editUser = (EditText) findViewById(R.id.editUser);
                editPass = (EditText) findViewById(R.id.editPass);
                btnlogin= findViewById(R.id.btlg);
                btndangki= findViewById(R.id.btndk) ;
                CheckBox =  findViewById(R.id.showpass);
                user.add(new User("rit","rit"));
                user.add(new User("thu","rit"));
                user.add(new User("anh","rit"));
                user.add(new User("hanh","rit"));
                CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                    if(b){
                        editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    }
                });



    }
    private void ControlBtn(){
        btncall=findViewById(R.id.btncall);
        btnweb = findViewById(R.id.btnweb);
        btnfb=findViewById(R.id.btnfb);
        btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/nettruyen/");
            }
        });
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://www.nettruyenvip.com/");
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "0123456789";
                String s = "tel:"+phone;
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                startActivity(intent);
            }
        });
        btndangki.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại đăng kí");
                dialog.setCancelable(false);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dangki);
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                EditText edtk = (EditText)dialog.findViewById(R.id.editUser_SU);
                final EditText edmk = (EditText)dialog.findViewById(R.id.editPass_SU);
                Button btndongy = (Button)dialog.findViewById(R.id.btndongy);
                Button btnback = (Button)dialog.findViewById(R.id.btnthoat);
                btnback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user.add(new User(edtk.getText().toString(),edmk.getText().toString()));
                        Toast.makeText(MainActivity.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

            }
        });
       btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                if(editUser.getText().length() != 0 && editPass.getText().length() != 0){
                    if(isPassword(user,editUser.getText().toString(),editPass.getText().toString())==true){
                           Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                           username = editUser.getText().toString();
                           password = editPass.getText().toString();
                           Bundle bundle = new Bundle();
                           bundle.putString("user", username);
                           bundle.putString("pass", password);
                           intent = new Intent(MainActivity.this,MainActivity2.class);
                           intent.putExtras(bundle);
                           startActivity(intent);

                    }
                    else {
                        Toast.makeText(MainActivity.this,"Tài khoản hoặc mật khẩu sai",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }
    public boolean isPassword(ArrayList<User> data, String username, String password) {
        for (User i : data) {
                if (i.getPassword().compareTo(password)==0 && i.getUsername().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        return false;
    }

}