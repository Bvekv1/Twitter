package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {
     TextInputEditText etName, etEmail;
     Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnCheck = findViewById(R.id.btnCheck);
//        etName.addTextChangedListener(emptyTextWatcher );
//        etEmail.addTextChangedListener(emptyTextWatcher );
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,SignUpConfirm.class);
                intent.putExtra("Name",etName.getText().toString());
                intent.putExtra("Email",etEmail.getText().toString());
                 startActivity(intent);
            }
        });
    }
//    private TextWatcher emptyTextWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            String name = etName.getText().toString().trim();
//            String email = etEmail.getText().toString().trim();
//            btnNext.setEnabled(!name.isEmpty() && !email.isEmpty());
//
//
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//
//        }
//    };
}

