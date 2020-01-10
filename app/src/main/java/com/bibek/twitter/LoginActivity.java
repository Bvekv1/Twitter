
package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bibek.twitter.BussinessLogic.LoginLogic;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText etEmailUser, etPasswordUser;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmailUser = findViewById(R.id.etEmailUser);
        etPasswordUser = findViewById(R.id.etPasswordUser);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });
    }
    private void login(){

        LoginLogic loginLogic = new LoginLogic();
       if (loginLogic.checkUser(etEmailUser.getText().toString(),etPasswordUser.getText().toString())== true) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
