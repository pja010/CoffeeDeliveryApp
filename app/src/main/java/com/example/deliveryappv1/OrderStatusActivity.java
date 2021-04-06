package com.example.deliveryappv1;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrderStatusActivity extends AppCompatActivity {
    final long DELIVERY_TIME = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);
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