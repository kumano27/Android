package com.example.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        // ListViewにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        /**
         * AdapterView<?> parent : タップされたリスト全体を表す。タップイベントそのものはリスト中の1行に対して起こるが、その1行を含むリスト全体が引数として渡される。
         * View view : タップされた1行分の画面部品そのものを表す。
         * int position ： タップされた行番号を表す。
         * long id : SimpleCursorAdapter を利用する場合、DBの主キーの値を表す。それ以外は position と同じ値が渡される
         *
         */
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            // タップされた定食名を取得
            /**
             * getItemAtPosition() : 引数として行番号を渡すと、リストデータのうちでその行番号に該当するデータを返す。ここでの引数は position
             *                      戻り値の型がObjectの為Stringにキャストする必要がある。
             */
            String item = (String)parent.getItemAtPosition(position);
            // トースト(画面中央下へ、テキストを表示して消える通知方法)で表示する文字列生成
            String show = "あなたが選んだ定食：" + item;
            // トーストの表示
            /**
             * 第1引数：Context context -> トーストを表示させるアクティビティオブジェクトを指定する。Android開発ではコンテキストと呼ぶ。通常「アクティビティ名.this」と記述
             * 第2引数：CharSequence text -> 表示文字列指定。文字列を直接引数として指定しても良いが、string.xmlに記述された文字列のR値を渡すことも可
             * 第3引数：int duration -> トーストが表示される長さをToastクラスの定数を使って指定する。定数は、 Toast.LENGTH_LONG(長い)、Toast.LENGTH_SHORT(短い)の2種類しかない
             */
            Toast.makeText(MainActivity.this, show,Toast.LENGTH_LONG).show();
        }
    }

}
