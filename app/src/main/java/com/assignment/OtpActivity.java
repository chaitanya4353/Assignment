package com.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assignment.utils.CommonMethods;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    CommonMethods commonMethods;
    TextView txtTimer;
    Button btnLogin;
    LinearLayout linearCountDown;

    EditText edt1,edt2,edt3,edt4,edt5,edt6;

    private CountDownTimer mCountDownTimer;
    private static final long START_TIME_IN_MILLIS = 30000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        commonMethods = new CommonMethods(this);

        txtTimer = findViewById(R.id.txtTimer);
        btnLogin = findViewById(R.id.btnLogin);
        linearCountDown = findViewById(R.id.linearCountDown);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);
        edt6 = findViewById(R.id.edt6);

        startTimer();

        btnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogin){
            if(edt1.getText().toString().length()==1&&
                edt2.getText().toString().length()==1&&
                edt3.getText().toString().length()==1&&
                edt4.getText().toString().length()==1&&
                edt5.getText().toString().length()==1&&
                edt6.getText().toString().length()==1){
                commonMethods.hideSoftKeyboard();
                startActivity(new Intent(OtpActivity.this, RegistrationActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            } else {
                commonMethods.hideSoftKeyboard();
                commonMethods.showSnackBar(this,view,"Invalid OTP");
            }
        } else if(view.getId() == R.id.linearCountDown){
            finish();
//            startActivity(new Intent(OtpActivity.this, LoginActivity.class));

        }
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                linearCountDown.setVisibility(View.GONE);
            }
        }.start();

    }

    private void updateCountDownText() {
        txtTimer.setVisibility(View.VISIBLE);
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        txtTimer.setText(timeLeftFormatted);
    }
}