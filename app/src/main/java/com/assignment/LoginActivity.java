package com.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.assignment.utils.CommonMethods;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    CommonMethods commonMethods;
    Button btnGetOtp;
    EditText edtMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        commonMethods = new CommonMethods(this);

        btnGetOtp = findViewById(R.id.btnGetOtp);
        edtMobile = findViewById(R.id.edtMobile);

        btnGetOtp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnGetOtp){
            if(edtMobile.getText().toString().length()==10){
                commonMethods.hideSoftKeyboard();
                startActivity(new Intent(LoginActivity.this, OtpActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            } else {
                commonMethods.showSnackBar(this,view,"mobile number should be 10 digits");
            }
        }
    }


}