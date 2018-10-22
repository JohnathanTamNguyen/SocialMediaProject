package com.example.android.socialmediaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class register_picture extends AppCompatActivity {

    Button registerPictureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_picture);
        Log.v("register_birthday", "TEEESST22" + getIntent().getSerializableExtra("userData"));

        registerPictureBtn = (Button)findViewById(R.id.register_picture_btn);

        registerPictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_picture.this, LoginActivity.class);
                HashMap<String, String> data = (HashMap<String, String>) getIntent().getSerializableExtra("userData");
                sendRegisterInfo(
                        data.get("username"),
                        data.get("email"),
                        data.get("password"),
                        data.get("passwordConfirm"),
                        data.get("date_of_birth_year") + " " + data.get("date_of_birth_month") + " " + data.get("date_of_birth_day"));
                startActivity(intent);
                //Log.v("register_picture", "TEEESSSSSTT" + data.get("date_of_birth_year") + data.get("date_of_birth_month") + data.get("date_of_birth_day"));
            }
        });

    }

    public void sendRegisterInfo(String username, String email, String password, String passwordConfirm, String date_of_birth) {
//        if(password.getText().toString() != passwordConfirm.getText().toString()){
//            Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
//        }
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://social-media-project.herokuapp.com/register";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", email);
        params.put("username", username);
        params.put("password", password);
        params.put("date_of_birth", date_of_birth);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(register_picture.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(register_picture.this, "Form incorrect", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonObjectRequest);
    }
}
