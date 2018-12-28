package com.example.operatingtime;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // システムの稼働時間取得
        long ut = SystemClock.uptimeMillis();

        // テキストビューのインスタンス取得
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = (TextView) findViewById(R.id.textView4);
        TextView tv5 = (TextView) findViewById(R.id.textView5);

        // システムの稼働時間を各単位にしたものを変数に代入
        String ms = "(ミリ秒単位)" + ut;
        String sec = "(秒単位)" + (ut / 1000);
        String min = "(分単位)" + (ut / 1000 / 60);
        String hr = "(時間単位)" + (ut / 1000 / 60 / 60) + ":" + (ut / 1000 / 60 % 60);

        // それぞれの単位の稼働時間をテキストビューに表示する
        tv2.setText(ms);
        tv3.setText(sec);
        tv4.setText(min);
        tv5.setText(hr);

    }
}
