package com.ltdd.quiz.lichSu;


import android.content.Context;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ltdd.quiz.DBHelper;
import com.ltdd.quiz.Danh_Sach_De_Thi;
import com.ltdd.quiz.MainActivity;
import com.ltdd.quiz.R;
import com.ltdd.quiz.function;

import java.util.ArrayList;

public class LichSuMau extends AppCompatActivity {
    ListView listView;
    Context context;
    ArrayList<ItemLichSu> arrayList;
    LichSuAdapter lichSuAdapter;
    DBHelper db;
    TextView ic_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lich_su_thi);
        db = new DBHelper(this);
        context = this;
        ic_exit =findViewById(R.id.ic_exit);
        listView = (ListView) findViewById(R.id.lvLichSu);
        arrayList = new ArrayList<>();
        lichSuAdapter = new LichSuAdapter(this,arrayList,R.layout.item_lich_su);
        listView.setAdapter(lichSuAdapter);
ic_exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LichSuMau.this, function.class);
        startActivity(intent);

    }
});
        Cursor cursor = db.getData("select * from story");
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            String tende = cursor.getString(1);
            Log.d("Tag", "tag");
            String soCauDung =cursor.getString(2);
            String soCauSai = cursor.getString(3);
            String tongCau = cursor.getString(4);
            arrayList.add(new ItemLichSu(id,tende,soCauDung,soCauSai,tongCau));
        }
    }
}
