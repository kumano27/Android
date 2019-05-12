package com.example.buttontap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView型のローカル変数tvを作成、テキストビュー「textView」のインスタンス参照情報を代入。
        // テキストビューはXMLファイルで定義しているので、XMLのコードに基づいてインスタンス化
        // Javaのコードからインスタンスにアクセスするには findViewById() メソッドでインスタンスの参照情報を手に入れることが必要。
            // findViewById()メソッド
            // 引数に指定したIDのint型の値を参照して、Activity型のインスタンスを返す
        // final は変数を定数として宣言するためのキーワードとして使用
        final TextView tv = (TextView) findViewById(R.id.textView);

        // final 外したら「エラー: ローカル変数tvは内部クラスからアクセスされます。finalで宣言される必要があります」
            // https://happynow.hateblo.jp/entry/20120512/1336826316
            // Java8 では本当に final であれば記述省略可能？？
                // https://teratail.com/questions/114613
        //TextView tv = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button)
                // setOnClickListener:ビューがクリックされたことを検知するイベントリスナーをビューのインスタンスに登録
                .setOnClickListener(
                        // View.OnClickListener():クリックされたビューのインスタンスの参照をView型として受け取る
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv.setText("Button Pushed");
                            }
                        }
                );
    }
}
