package com.ltdd.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltdd.quiz.lichSu.LichSuMau;

public class function extends AppCompatActivity {
    TextView thi,xemlichsu,thoat;
    DBHelper db;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        db = new DBHelper(this);
        xemlichsu = (TextView) findViewById(R.id.xemlichsu);
        thoat = (TextView) findViewById(R.id.thoat);
        thi = (TextView)findViewById(R.id.thi);
        DBHelper db = new DBHelper(this);

        thi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Danh_Sach_De_Thi.class));
                finish();
            }
        });

        xemlichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LichSuMau.class));
                finish();
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}