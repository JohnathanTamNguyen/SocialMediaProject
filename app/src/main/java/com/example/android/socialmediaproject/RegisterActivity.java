package com.example.android.socialmediaproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class RegisterActivity extends AppCompatActivity {

    Button registerBtn;
    EditText username;
    EditText email;
    EditText password;
    EditText passwordConfirm;
    EditText dateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = (Button) findViewById(R.id.register_btn);
        username = (EditText) findViewById(R.id.register_username);
        email = (EditText) findViewById(R.id.register_email);
        password = (EditText) findViewById(R.id.register_password);
        passwordConfirm = (EditText) findViewById(R.id.register_confirm_password);
        dateOfBirth = (EditText) findViewById(R.id.date_of_birth);

        dateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 2 || s.length() == 5){
                    dateOfBirth.setText(s + "/");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changeActivity(RegisterActivity.this, LoginActivity.class);
                sendRegisterInfo(username, email, password, passwordConfirm, dateOfBirth);
            }
        });
    }

    //Function used for changing activities
    public void changeActivity(Activity thisActivity, Class nextActivity){
        Intent intent = new Intent(thisActivity, nextActivity);
        startActivity(intent);
    }

    public void sendRegisterInfo(EditText username, EditText email, EditText password, EditText passwordConfirm, EditText date_of_birth) {
//        if(password.getText().toString() != passwordConfirm.getText().toString()){
//            Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
//        }
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://social-media-project.herokuapp.com/register";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", email.getText().toString());
        params.put("username", username.getText().toString());
        params.put("password", password.getText().toString());
        params.put("date_of_birth", date_of_birth.getText().toString());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.v("LoginActivity", "It works!");
                        changeActivity(RegisterActivity.this, LoginActivity.class);
                        Log.v("RegisterActivity", response.toString());
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.v("LoginActivity", error.toString());
                        Toast.makeText(RegisterActivity.this, "Form incorrect", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonObjectRequest);
    }
}
