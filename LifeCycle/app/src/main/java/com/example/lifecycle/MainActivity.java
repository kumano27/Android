package com.example.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ログ出力
        Log.i("TEST","onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        // ログ出力
        Log.i("TEST","onStart()");
        // スーパークラスのメソッド呼び出し
        super.onStart();
    }

    @Override
    protected void onResume(){
        // ログ出力
        Log.i("TEST","onResume()");
        // スーパークラスのメソッド呼び出し
        super.onResume();
    }

    @Override
    protected void onPause(){
        // ログ出力
        Log.i("TEST","onPause()");
        // スーパークラスのメソッド呼び出し
        super.onPause();
    }

    @Override
    protected void onStop(){
        // ログ出力
        Log.i("TEST","onStop()");
        // スーパークラスのメソッド呼び出し
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        // ログ出力
        Log.i("TEST","onDestroy()");
        // スーパークラスのメソッド呼び出し
        super.onDestroy();
    }
}
