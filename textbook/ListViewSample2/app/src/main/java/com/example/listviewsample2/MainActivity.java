package com.example.listviewsample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView オブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        // リストビューに表示するリストデータ用Listオブジェクトを作成
        List<String> menuList =new ArrayList<>();
        // ①　リストデータの登録
        menuList.add("から揚げ定食");
        menuList.add("ハンバーグ定食");
        menuList.add("生姜焼き定食");
        menuList.add("ステーキ定食");
        menuList.add("野菜炒め定食");
        menuList.add("とんかつ定食");
        menuList.add("メンチカツ定食");
        menuList.add("チキンカツ定食");
        menuList.add("コロッケ定食");
        menuList.add("焼き魚定食");
        menuList.add("焼肉定食");

        // ②　アダプタオブジェクトを生成
        /**
         * アダプタ：リストビューに表示するリストデータを管理し、リストビューの各行にそのリストデータを当てはめていく働きをするオブジェクト
         * アダプタオブジェクトを生成するには、Adapter インターフェースを実装したクラスを利用する。以下よく使用される3種類
         * ・ArrayAdapter：元データとしてList(配列)を利用するアダプタクラス
         * ・SimpleAdapter：元データとしてList<Map<String.?>を利用するアダプタクラス。XMLデータやJSONデータの解析結果を格納するのに便利。
         * ・SimpleCursorAdapter：元データとしてCursorオブジェクトを利用するアダプタクラス。Android端末内のDBを利用する際、SELECT分の結果が格納されたもの
         *
         * 今回の例は ArrayAdapter を利用
         * 引数1：コンテキスト
         * 引数2：リストビューの各行のレイアウトを表すR値
         * 引数3：リストデータそのもの
         *
         * 引数2に関して追記。ListViewは各行に様々な画面部品を埋め込むことが出来る。
         * この埋め込みは、専用のレイアウトXMLファイルを作ることで実現可能。
         * レイアウトXMLファイルを作成するという事はR値が存在する。それを引数2として指定する。
         * ただし、1～2行程度のシンプルなレイアウトの場合、AndroidSDKで用意されている下記を使用する。
         * android.R.layout.simple_list_item_1
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, menuList);

        // ③　リストビューにアダプタオブジェクトを設定
        lvMenu.setAdapter(adapter);

        // リストビューにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 注文確認ダイアログフラグメントオブジェクトを生成
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();

            // ダイアログ表示
            /**
             * showメソッド
             * 第1引数：FragmentManagerオブジェクト、ここでは getSupportFragmentManager() の戻り値設定
             * 第2引数：ダイアログを識別する為のタグ文字列。任意の文字列設定可能。ここではクラス名をそのまま渡している。
             */
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }
}
