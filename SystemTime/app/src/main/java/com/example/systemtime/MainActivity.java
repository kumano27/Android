package com.example.systemtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calendar クラスのクラス変数が格納されたインスタンス作成
        Calendar obj_cd = Calendar.getInstance();

        // 午前/午後の取得(0:AM,1:PM)
        String am_pm;
        if(obj_cd.get(Calendar.AM_PM) == 0 ) {
            // 0なら午前
            am_pm = "午前";
        }else{
            // 1なら午後
            am_pm = "午後";
        }

        int yr = obj_cd.get(Calendar.YEAR);
        // 月の値は 0 ～ 11 で返されるので 1 を加算する
        int mth = obj_cd.get(Calendar.MONTH)+1;         // 月データ取得
        int dt = obj_cd.get(Calendar.DATE);             // 日データ取得
        int hr12 = obj_cd.get(Calendar.HOUR);           // 12時間単位の時間取得
        int hr24 = obj_cd.get(Calendar.HOUR_OF_DAY);    // 24時間単位の時間取得
        int mt = obj_cd.get(Calendar.MINUTE);           // 分取得
        int sd = obj_cd.get(Calendar.SECOND);           // 秒取得
        int msd = obj_cd.get(Calendar.MILLISECOND);     // ミリ秒取得

        // 表示形式を設定(yr年mth月dt日)
        String format1 = yr + "年" + mth + "月" + dt + "日";

        // 表示形式を設定(am_pm(午前/午後) hr12 時 mt 分 sd 秒 mm
        String format2 = am_pm + hr12 + "時" + mt + "分" + sd + "秒" + msd;

        // 表示形式を設定(hr24 時 mt 分 sd 秒 mm
        String format3 = hr24 + "時" + mt + "分" + sd + "秒" + msd;

        // 現在時刻をテキストビューへ表示
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("現在の日付：\n\n" + format1 + "\n" + format2 + "\n" + format3);

    }
}
