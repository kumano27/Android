package com.example.contentresolver;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // テキストビューのインスタンス取得
        TextView tv = ( TextView ) findViewById(R.id.textView);

        // 画面の明るさを示す数値取得
        // 照度の定数名はフルネームで「Settings.System.SCREEN_BRIGHTNESS」と書く必要があるが、「"screen_brightness"」のように定数名を小文字の文字列として書いても良い
        String brightness = Settings.System.getString(this.getContentResolver(), "screen_brightness");

        // 取得した画面の明るさの数値をテキストビューに表示する。
        // AVDではデフォルトで「102」が出力される
        tv.setText("画面の明るさ：" + brightness);
    }
}
