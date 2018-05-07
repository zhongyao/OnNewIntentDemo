package com.hongri.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author hongri
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Logger.d("SecondActivity-------->onCreate");

        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("age", "28");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.d("SecondActivity-------->onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.d("SecondActivity-------->onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d("SecondActivity-------->onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d("SecondActivity-------->onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d("SecondActivity-------->onResume");
        //Intent intent = new Intent();
        //intent.putExtra("name", "hongri");
        //setResult(200, intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d("SecondActivity-------->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d("SecondActivity-------->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("SecondActivity-------->onDestroy");
    }
}
