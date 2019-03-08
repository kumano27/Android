package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ブロードキャストレシーバーのインスタンスをフィールドに格納
    private BroadcastReceiver br =
            new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    // インテントのアクションがACTION_BATTERY_CHANGEDの場合の処理
                    if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
                        // バッテリーの残量を取得
                        int level = intent.getIntExtra("level",0);
                        // バッテリーの最大値を取得
                        int scale = intent.getIntExtra("scale",0);
                        // バッテリーの残量を%単位でテキストビューへ表示
                        TextView tv = (TextView) findViewById(R.id.textView);
                        tv.setText("バッテリーの残量：" +
                                ((float) level / (float) scale * 100) + "(%)");
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume(){
        super.onResume();
        // インデントフィルターの登録
        IntentFilter newIntentFilter = new IntentFilter();
        // インデントフィルターへACTION_BATTERY_CHANGEDアクションを登録
        newIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        // ブロードキャストレシーバ―を登録
        registerReceiver(br, newIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // ブロードキャストレシーバ―の登録を削除
        unregisterReceiver(br);
    }
}
