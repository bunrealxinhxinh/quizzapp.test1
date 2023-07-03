package com.ltdd.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowChecked extends AppCompatActivity {
    private ListView listView;
    private ResultCheckedAdapter adapter;
    private List<String> resultCheckedList;
//    private ResultGroupAdapter adapter;
//    private List<ResultGroup> resultGroupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_checked);

        listView = findViewById(R.id.listView);
        resultCheckedList = new ArrayList<>();
        adapter = new ResultCheckedAdapter(this, resultCheckedList);
        listView.setAdapter(adapter);

        getResultCheckedData();
    }

    private void getResultCheckedData() {
        // Assuming you have a SQLite database helper class named "MyDatabaseHelper"
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                "id",
                "dapanchon"
        };

        Cursor cursor = db.query(
                "resultchecked",
                projection,
                null,
                null,
                null,
                null,
                null
        );

        resultCheckedList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String dapanchon = cursor.getString(cursor.getColumnIndexOrThrow("dapanchon"));
            int id_div=id%10;
            String resultCheckedData = "Câu: " + id_div + ", Dap an chon: " + dapanchon;

            resultCheckedList.add(resultCheckedData);
        }

        cursor.close();
        db.close();

        adapter.notifyDataSetChanged();
    }
}