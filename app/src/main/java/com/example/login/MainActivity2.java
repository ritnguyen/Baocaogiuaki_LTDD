package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Blob;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Button btnBack;
    ImageButton btnadd,btndelete,btnupdate;
    ListView lv;
    ArrayList<Truyen> truyen ;
    TruyenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh2);
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
    }
    public  void DialogXoa(String tentruyen , int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa truyện "+tentruyen+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.DB.execSQL("DELETE FROM truyen WHERE Id = '"+id+"'");
                Toast.makeText(MainActivity2.this,"Xóa Thành Công",Toast.LENGTH_SHORT).show();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }
    private void Anhxa(){
        lv = (ListView) findViewById(R.id.listview);
        adapter = new TruyenAdapter(this,R.layout.truyen,truyen);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        btnBack= (Button) findViewById(R.id.btnback);
        btnadd = (ImageButton) findViewById(R.id.btnadd);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                int ID = i;
                Bundle bundle = new Bundle();
                bundle.putInt("id", ID);
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,ActivityThem.class);
                startActivity(intent);
            }
        });
    }
}