package com.example.deliveryappv1;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class UserInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        Intent testIntent = new Intent(UserInformationActivity.this, OrderStatusActivity.class);
        String userInfo = null;
        testIntent.putExtra("USER_INFO_STRING", userInfo);
    }

    public void confirmOrder(View view) {
        Intent intent = new Intent(this, OrderStatusActivity.class);
        startActivity(intent);
    }
}