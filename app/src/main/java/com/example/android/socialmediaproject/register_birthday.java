package com.example.android.socialmediaproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.HashMap;

public class register_birthday extends AppCompatActivity {

    Button registerBirthdayBtn;
    DatePicker registerBirthdayPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_birthday);

        registerBirthdayBtn = (Button)findViewById(R.id.register_birthday_btn);
        registerBirthdayPicker = (DatePicker)findViewById(R.id.register_date_of_birth);

        registerBirthdayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_birthday.this, register_picture.class);
                Log.v("register_birthday", "TEEESST" + getIntent().getSerializableExtra("userData"));
                HashMap<String, String> params = (HashMap<String, String>) getIntent().getSerializableExtra("userData");
                params.put("date_of_birth_day", Integer.toString(registerBirthdayPicker.getDayOfMonth()));
                params.put("date_of_birth_month", Integer.toString(registerBirthdayPicker.getMonth()));
                params.put("date_of_birth_year", Integer.toString(registerBirthdayPicker.getYear()));
                intent.putExtra("userData", params);
                startActivity(intent);
            }
        });
    }

    //Function used for changing activities
    public void changeActivity(Activity thisActivity, Class nextActivity){
        Intent intent = new Intent(thisActivity, nextActivity);
        startActivity(intent);
    }
}
