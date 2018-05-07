package com.hongri.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author hongri
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d("MainActivity-->onCreate");
        if (savedInstanceState == null) {
            Logger.d("MainActivity-->onCreate:savedInstanceState is null");
        } else {
            Logger.d("MainActivity-->onCreate:savedInstanceState is:" + savedInstanceState.toString());
        }
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //SecondActivity.flag = false;
                ////Intent intent = new Intent(MainActivity.this, MainActivity.class);
                //new Handler().postDelayed(new Runnable() {
                //    @Override
                //    public void run() {
                //
                //    }
                //}, 100);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("time", System.currentTimeMillis() + "");
                startActivity(intent);

                //startActivityForResult(intent, 100);
            }
        });
    }

    /**
     * 1、让后台的Activity回到前台，并为其传递一些数据是需要用到该方法
     * 获取新的intent数据时需要设置setIntent(intent)方法，
     * 否则gentIntent()会获取的老的数据信息
     *
     * 2、直接finish掉SecondActivity或按back物理键的时候不会调用该方法
     * 重新StartActivity的时候才会调用该方法。
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        Logger.d("MainActivity-->onNewIntent");

        processExtraData();
        /**
         * <1>当直接使用finish时的生命周期：
         * onCreate-->onStart-->onResume-->onPause-->onStop -->
         * onNewIntent --> finish -->onDestroy
         *
         * <2>当使用postDelayed来延迟finish时候的生命周期：
         * onCreate-->onStart-->onResume-->onPause-->onStop --->
         * onNewIntent-->onRestart-->onStart-->onResume-->
         * finish-->onPause-->onStop-->onDestroy
         *
         */
        //new Handler().postDelayed(new Runnable() {
        //    @Override
        //    public void run() {
        //        finish();
        //    }
        //}, 3000);

        //finish();
    }

    private void processExtraData() {
        Intent intent = getIntent();
        Logger.d("MainActivity-->processExtraData:" + intent + " " + intent.getStringExtra("age"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.d("MainActivity-->onSaveInstanceState is-----:" + outState.toString());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.d("MainActivity-->onActivityResult is " + " requestCode:" + requestCode + " resultCode:" + resultCode
            + " data:" + data.getStringExtra("name"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.d("MainActivity-->onRestoreInstanceState is:" + savedInstanceState.toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d("MainActivity-->onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d("MainActivity-->onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Logger.d("MainActivity-->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d("MainActivity-->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d("MainActivity-->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("MainActivity-->onDestroy");
    }

    @Override
    public void finish() {
        super.finish();
        Logger.d("MainActivity-->finish");
    }
}
