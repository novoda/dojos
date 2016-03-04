package com.example.android.automessagingcodelab;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int DELAY_MILLIS = 15000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private TextView contentText;
    private CountDownTimer countDownTimer;
    private TextView helpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helpText = (TextView) findViewById(R.id.help_text);
        contentText = (TextView) findViewById(R.id.context_text);
        Button startButton = (Button) findViewById(R.id.start_conversation);
        startButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startCountDownTimer();
                    }
                }
        );
    }

    private void startCountDownTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(DELAY_MILLIS, COUNT_DOWN_INTERVAL) {

            public void onTick(long millisUntilFinished) {
                helpText.setVisibility(View.VISIBLE);
                contentText.setText("Posting notification in " + (millisUntilFinished / 1000));
            }

            public void onFinish() {
                helpText.setVisibility(View.GONE);
                contentText.setText("Notification Posted");
                sendMessage();
            }
        };
        countDownTimer.start();
    }

    private void sendMessage() {
        Intent serviceIntent = new Intent(MainActivity.this, MessagingService.class);
        serviceIntent.setAction(MessagingService.SEND_MESSAGE_ACTION);
        startService(serviceIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
