package com.example.deliveryappv1;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AdjustOrderActivity extends AppCompatActivity {

    public static final String EXTRA_COFFEEID = "coffe_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_order);

        int coffeeId = (Integer) getIntent().getExtras().get(EXTRA_COFFEEID);
        Coffee coffee = Coffee.coffeeList[coffeeId];

        TextView currentOrderInfo = findViewById(R.id.currentOrderInfo);
        currentOrderInfo.setText(coffee.toString());
    }

    public void confirmSelction(View view) {
        Intent confirmChoiceIntent = new Intent(this, UserInformationActivity.class);
//        orderInfoIntent.putExtra("orderInformation", orderInformation);
        startActivity(confirmChoiceIntent);
    }
}