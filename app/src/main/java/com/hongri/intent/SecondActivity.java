package com.hongri.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SecondActivity extends Activity {
    public static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("age", "28");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Intent intent = new Intent();
        //intent.putExtra("name", "hongri");
        //setResult(200, intent);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
