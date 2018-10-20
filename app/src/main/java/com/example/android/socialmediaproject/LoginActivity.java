package com.example.android.socialmediaproject;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button signInBtn;
    TextView signUpBtn;
    EditText loginEmail;
    EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInBtn = (Button) findViewById(R.id.sign_in_btn);
        signUpBtn = (TextView) findViewById(R.id.sign_up_btn);
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //changeActivity(LoginActivity.this, Newsfeed.class);
                sendLoginInfo(loginEmail, loginPassword);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(LoginActivity.this, RegisterActivity.class);
            }
        });
    }

    //Function used for changing activities
    public void changeActivity(Activity thisActivity, Class nextActivity){
        Intent intent = new Intent(thisActivity, nextActivity);
        startActivity(intent);
    }

    public void sendLoginInfo(EditText email, EditText password) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://social-media-project.herokuapp.com/signin";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", email.getText().toString());
        params.put("password", password.getText().toString());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.v("LoginActivity", "It works!");
                        changeActivity(LoginActivity.this, Newsfeed.class);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.v("LoginActivity", error.toString());
                        Toast.makeText(LoginActivity.this, "The information you entered is wrong", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonObjectRequest);
    }
}
