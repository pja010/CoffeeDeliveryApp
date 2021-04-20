package com.example.deliveryappv1;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public class MainActivity extends AppCompatActivity {

//    int coffeeTypeQuantity = 0; // number of textviews to add
//    final ArrayList<TextView> chosenCoffeeTypes = new ArrayList<TextView>();
//    final ArrayList<String> chosenCoffeeTypes = new ArrayList<>();
//    HashMap<String, Integer> orderInformation = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout llLayout = findViewById(R.id.llLayoutMain);
//        Spinner spinner = (Spinner) findViewById(R.id.coffee_choice_spinner);
//        spinner.setOnItemSelectedListener(this);

//        ArrayAdapter<Coffee> itemListAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                Coffee.coffeeList);
//        ListView listView = (ListView) findViewById(R.id.order_options_list);
//        listView.setAdapter(itemListAdapter);

//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, AdjustOrderActivity.class);
//                intent.putExtra(AdjustOrderActivity.EXTRA_COFFEEID, (int) id);
//                startActivity(intent);
//            }
//        };
////        ListView listView2 = (ListView) findViewById(R.id.order_options_list);
//        listView.setOnItemClickListener(itemClickListener);

        // for fut reference, id for user's coffee
//        int itemId = (Integer)getIntent().getExtras().get(EXTRA_ITEMID);
//        SQLiteOpenHelper orderDatabaseHelper = new OrderDatabaseHelper(this);
//        try {
//            OrderDatabaseHelper databaseHelper = new OrderDatabaseHelper(this);
//            SQLiteDatabase db = OrderDatabaseHelper.getWritableDatabase();
//            SQLiteDatabase db = databaseHelper.getReadableDatabase();
//            Cursor cursor = db.query("COFFEE_DATA",
//                    new String[]{"TYPE", "PRICE"},
//                    null, null, null, null, null);
//            if (cursor.moveToFirst()) {
//                String coffeeType = cursor.getString(0);
//                int price = cursor.getInt(1);
//            }
//            cursor.close();
//            db.close();
//
//        } catch (SQLException e) {
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }

//        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, )


//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.coffee_options_array,
//                android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        String sUserChoice = spinner.getItemAtPosition(0).toString();
//        orderInformation.put(sUserChoice, 1);
//        orderInformation.put(sUserChoice, 2);


//        final TextView[] customerChoiceTextViews = new TextView[coffeeTypeQuantity]; // create an empty array;
//
//        for (int i = 0; i < chosenCoffeeTypes.size(); i++) {
//            // create a new textview
//            final TextView textView = new TextView(this);
//
//            // set some properties of rowTextView or something
//            textView.setText(" 1 st " + chosenCoffeeTypes.get(i));
//
//            // add the textview to the linearlayout
////            llLayout.addView(textView);
//
//            // save a reference to textview
//            customerChoiceTextViews[i] = textView;
//
////            textView.setText("I am added dynamically to the view");
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.MATCH_PARENT
//            );
//            textView.setLayoutParams(params);
//            llLayout.addView(textView);
//        }

}

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
//     * Implementers can call getItemAtPosition(position) if they need to access the
//     * data associated with the selected item.
//     *
//     * @param parent   The AdapterView where the selection happened
//     * @param view     The view within the AdapterView that was clicked
//     * @param position The position of the view in the adapter
//     * @param id       The row id of the item that is selected
//     */
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String sUserChoice = parent.getItemAtPosition(position).toString();
//        coffeeTypeQuantity += 1;
////        orderInformation.put(sUserChoice, 1);
//        if (!orderInformation.containsKey(sUserChoice)) {
//            orderInformation.put(sUserChoice, 1);
//        }
////        orderInformation.put(sUserChoice, 1);
//        Log.i("Testing map before input, item is:", sUserChoice);
//        Log.i("quantity is: ", Integer.toString(coffeeTypeQuantity));
//        if (!chosenCoffeeTypes.contains(sUserChoice)){
//            chosenCoffeeTypes.add(sUserChoice);
//        }
//    }
//
//    /**
//     * Callback method to be invoked when the selection disappears from this
//     * view. The selection can disappear for instance when touch is activated
//     * or when the adapter becomes empty.
//     *
//     * @param parent The AdapterView that now contains no selected item.
//     */
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }


    public void confirmChoice(View view) {
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
//        Intent confirmChoiceIntent = new Intent(this, UserInformationActivity.class);
//        Intent orderInfoIntent = new Intent(this, OrderStatusActivity.class);
//        orderInfoIntent.putExtra("orderInformation", orderInformation);
//        startActivity(confirmChoiceIntent);
    }

}