package com.example.despkernlinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 文字列を格納する version 変数作成
        String version = null;
        try{
            // /proc に格納されているファイル version から文字を読み出し、バッファー(インスタンス reader )に格納
            BufferedReader reader = new BufferedReader(new FileReader("/proc/version"));
            // バッファーの文字列を変数に代入
            version = reader.readLine();
        }catch (FileNotFoundException e){     // ファイルが存在しない、アクセスできない場合
            // logcat ツールに書き出す
            Log.e("tag",e.toString());
        }catch (IOException e){               // バッファー文字に問題があった場合
            Log.e("tag",e.toString());
        }

        TextView text = (TextView)findViewById(R.id.textView);
        String str = "カーネルのバージョン：" + '\n' + version;
        text.setText(str);

    }
}
