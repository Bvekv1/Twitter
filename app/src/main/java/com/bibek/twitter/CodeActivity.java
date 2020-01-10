package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CodeActivity extends AppCompatActivity {
    Button btnCode;
    private String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        btnCode = findViewById(R.id.btnCode);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            name =bundle.getString("Name");
            email = bundle.getString("Email");
        }
        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodeActivity.this,PasswordActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });


    }
}
