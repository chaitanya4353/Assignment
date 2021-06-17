package com.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSkip;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegister = findViewById(R.id.btnRegister);
        txtSkip = findViewById(R.id.txtSkip);

        btnRegister.setOnClickListener(this);
        txtSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.txtSkip||view.getId() == R.id.btnRegister){
            Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.enter, R.anim.exit);

        }
    }
}