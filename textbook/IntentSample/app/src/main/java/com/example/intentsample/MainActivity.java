package com.example.intentsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面部品ListViewを取得
        ListView lvMenu = findViewById(R.id.lvMenu);

        // SimpleAdapter で使用するListオブジェクトを用意
        List<Map<String, String>> menuList = new ArrayList<>();

        // 「から揚げ定食」のデータを格納する Map オブジェクトの用意と menuList へのデータ登録
        Map<String, String> menu = new HashMap<>();
        menu.put("name","から揚げ定食");
        menu.put("price","800円");
        menuList.add(menu);
        // 「ハンバーグ定食」のデータを格納する Map オブジェクトの用意と menuList へのデータ登録
        menu = new HashMap<>();
        menu.put("name","ハンバーグ定食");
        menu.put("price","850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","生姜焼き定食");
        menu.put("price","850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","ステーキ定食");
        menu.put("price","1000円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","野菜炒め定食");
        menu.put("price","750円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","とんかつ定食");
        menu.put("price","900円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","メンチカツ定食");
        menu.put("price","850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","チキンカツ定食");
        menu.put("price","900円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name","コロッケ定食");
        menu.put("price","850円");
        menuList.add(menu);

        // SimpleAdapter 第4引数from用データの用意
        String[] from = {"name","price"};
        // SimpleAdapter 第5引数to用データの用意
        int[] to = {android.R.id.text1, android.R.id.text2};
        // SimpleAdapter を生成
        /**
         * ListViewSample2アプリでは、アダプタクラスとして ArrayAdapter を使用したが、この例では SimpleAdapter を使う
         *
         * simple_list_item_2：2行表示のリストとするため、Android SDK で用意されているものを使用
         */
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,menuList,android.R.layout.simple_list_item_2, from, to);
        // アダプタの生成
        lvMenu.setAdapter(adapter);
    }
}
