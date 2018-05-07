package com.hongri.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, MainActivity.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(WelcomeActivity.this, SecondActivity.class);
                        intent.putExtra("times", System.currentTimeMillis() + "");
                        startActivity(intent);
                    }
                }, 100);
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                intent.putExtra("time", System.currentTimeMillis() + "");
                startActivity(intent);
            }
        });
    }
}
