package com.ltdd.quiz.lichSu;


import android.content.Context;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ltdd.quiz.DBHelper;
import com.ltdd.quiz.MainActivity;
import com.ltdd.quiz.R;

import java.util.ArrayList;

public class LichSuMau extends AppCompatActivity {
    ListView listView;
    Context context;
    Button goback;
    ArrayList<ItemLichSu> arrayList;
    LichSuAdapter lichSuAdapter;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lich_su_thi);
        db = new DBHelper(this);
        context = this;
        listView = (ListView) findViewById(R.id.lvLichSu);
        goback = (Button) findViewById(R.id.goBack);
        arrayList = new ArrayList<>();
        lichSuAdapter = new LichSuAdapter(this,arrayList,R.layout.item_lich_su);
        listView.setAdapter(lichSuAdapter);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LichSuMau.this, MainActivity.class));
                finish();
            }
        });


        Cursor cursor = db.getData("select * from story");
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String tende = cursor.getString(1);
            String soCauDung =cursor.getString(2);
            String soCauSai = cursor.getString(3);
            String tongCau = cursor.getString(4);
            arrayList.add(new ItemLichSu(id,tende,soCauDung,soCauSai,tongCau));
        }
    }
}
