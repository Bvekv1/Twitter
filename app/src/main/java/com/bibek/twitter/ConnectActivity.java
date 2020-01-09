package com.bibek.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConnectActivity extends AppCompatActivity {
    TextView tvNotNOw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        tvNotNOw = findViewById(R.id.tvNotNow);
        tvNotNOw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity.this, DashBoardActivity.class);
                 startActivity(intent);
            }
        });
    }
}
