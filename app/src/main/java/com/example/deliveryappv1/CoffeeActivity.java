package com.example.deliveryappv1;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CoffeeActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

//        ArrayAdapter<Coffee> itemListAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                Coffee.coffeeList);
        ListView listView = (ListView) findViewById(R.id.order_options_list2);
//        listView.setAdapter(itemListAdapter);

//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(CoffeeActivity.this, AdjustOrderActivity.class);
//                intent.putExtra(AdjustOrderActivity.EXTRA_COFFEEID, (int) id);
//                startActivity(intent);
//            }
//        };
//        listView.setOnItemClickListener(itemClickListener);
        int coffeeId = 1;

        SQLiteOpenHelper databaseHelper = new OrderDatabaseHelper(this);
        try {
            db = databaseHelper.getReadableDatabase();
//            cursor = db.rawQuery("SELECT * FROM COFFEE_DATA", null);
            cursor = db.query("COFFEE_DATA",
                    new String[]{"_id", "TYPE"},
                     null, null, null, null, null);
//                    "_id = ?",
//                    new String[] {"Cortado"},
//                    new String[] {Integer.toString(coffeeId)},
//                     null, null, null);

            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"TYPE"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(listAdapter);

        } catch (SQLException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        AdapterView.OnItemClickListener itemClickListener
                = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CoffeeActivity.this,
                        AdjustOrderActivity.class);
                intent.putExtra(AdjustOrderActivity.EXTRA_COFFEEID, (int) id);
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}