package com.example.deliveryappv1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.HashMap;

public class OrderStatusActivity extends AppCompatActivity {
    final long DELIVERY_TIME = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        Intent orderInformationIntent = getIntent();
        HashMap<String, Integer> orderInformation = new HashMap<>();
        orderInformation = (HashMap<String, Integer>) orderInformationIntent.getSerializableExtra("orderInformation");
        // may need a check here, to get rid of the warning

//        orderInformation.put("temporary", 0);
//        if (savedInstanceState == null) {
//            Serializable bundle = getIntent().getSerializableExtra("orderInformation");
//            if (bundle == null) {
//                System.out.println("Failed");
//                //orderInformation.put("Nothing here", 0);
//            } else
//                orderInformation = (HashMap<String, Integer>) bundle;
//        }
//        else {
//            orderInformation = savedInstanceState.getSerializable("order")
//        }

//        R.log
        TextView displayOrder = findViewById(R.id.textViewOrderInformation);
        displayOrder.setText((CharSequence) orderInformation);
        final TextView timeDisplayText = findViewById(R.id.textViewTime);

        new CountDownTimer(DELIVERY_TIME, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeDisplayText.setText("Delivery Time: \n" + millisUntilFinished / 60000);
            }

            /**
             * Callback fired when the time is up.
             */
            @Override
            public void onFinish() {
            }
        }.start();
    }
}