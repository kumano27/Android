package com.example.lifecyclesample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LifeCycleSample", "Man onCreate() called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){
        Log.i("LifeCycleSample", "Man onStart() called.");
        super.onStart();
    }

    @Override
    public void onRestart(){
        Log.i("LifeCycleSample", "Man onRestart() called.");
        super.onRestart();
    }

    @Override
    public void onResume(){
        Log.i("LifeCycleSample", "Man onResume() called.");
        super.onResume();
    }

    @Override
    public void onPause(){
        Log.i("LifeCycleSample", "Man onPause() called.");
        super.onPause();
    }

    @Override
    public void onStop(){
        Log.i("LifeCycleSample", "Man onStop() called.");
        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.i("LifeCycleSample", "Man onDestroy() called.");
        super.onDestroy();
    }

    /**
     * [次の画面を表示] ボタンがタップされたときの処理
     */
    public void onButtonClick(View view){
        Intent intent = new Intent(MainActivity.this, LifeCycleSubActivity.class);

        // アクティビティを起動
        startActivity(intent);
    }
}
