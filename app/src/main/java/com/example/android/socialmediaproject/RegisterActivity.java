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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    Button registerBtn;
    EditText username;
    EditText email;
    EditText password;
    EditText passwordConfirm;
    TextView registerPasswordMatch;
    TextView registerPasswordRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = (Button) findViewById(R.id.register_btn);
        username = (EditText) findViewById(R.id.register_username);
        email = (EditText) findViewById(R.id.register_email);
        password = (EditText) findViewById(R.id.register_password);
        passwordConfirm = (EditText) findViewById(R.id.register_confirm_password);
        registerPasswordMatch = (TextView) findViewById(R.id.register_password_match);
        registerPasswordRules = (TextView) findViewById(R.id.register_password_rules);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordRulesNotMet(password)){
                    registerPasswordRules.setVisibility(View.VISIBLE);
                    return;
                }
                if(!password.getText().toString().equals(passwordConfirm.getText().toString())){
                    registerPasswordMatch.setVisibility(View.VISIBLE);

                } else {
                    Intent intent = new Intent(RegisterActivity.this, register_birthday.class);
                    HashMap<String, String> params = new HashMap<String, String>();
                    params.put("email", email.getText().toString());
                    params.put("username", username.getText().toString());
                    params.put("password", password.getText().toString());
                    intent.putExtra("userData", params);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean passwordRulesNotMet(EditText userPassword) {
        String password = userPassword.getText().toString();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);
        if(password.length() < 8){
            return true;
        } else if(password.isEmpty()){
            return true;
        } else if(matcher.matches()){
            return true;
        } else {
            return false;
        }
    }

}

