package com.example.fragmentsample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuListFragment extends Fragment {
    /**
     * このフラグメントが所属するアクティビティオブジェクト
     */
    private Activity _parentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState){
        // 親クラスの onCreate() 呼び出し
        super.onCreate(savedInstanceState);

        // 所属するアクティビティオブジェクトを取得
        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントで表示する画面を XML ファイルからインフレ―ト(中に吹き込む？)する
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);

        // 画面部品 ListView を取得
        ListView lvMenu = view.findViewById(R.id.lvMenu);

        // SimpleAdapter で使用する List オブジェクトを用意
        List<Map<String, String>> menuList = new ArrayList<>();
        
        // menuList データ生成
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
        menu = new HashMap<>();
        menu.put("name","焼き魚定食");
        menu.put("price","850円");
        menuList.add(menu);
        // SimpleAdapter 第4引数 from 用データの用意。
        String[] from = {"name","price"};

        // SimpleAdapter 第5引数 to 用データの用意。
        int[] to = {android.R.id.text1,android.R.id.text2};

        // SimpleAdapter を作成
        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);

        // アダプタの登録
        lvMenu.setAdapter(adapter);

        // リスナの登録
        lvMenu.setOnItemClickListener(new ListItemClickListener());

        // インフレートされた画面を戻り値として渡す
        return view;
    }

    /**
     * リストがタップされたときの処理記述されたメンバクラス
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // タップされた行のデータを取得、SimpleAdapter では1行分のデータはMap型
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            // 定食名と金額を取得
            String menuName = item.get("name");
            String menuPrice = item.get("price");

            // インテントオブジェクトを生成
            Intent intent = new Intent(_parentActivity, MenuThanksActivity.class);

            // 第2画面に送るデータを格納
            intent.putExtra("menuName",menuName);
            intent.putExtra("menuPrice",menuPrice);

            // 第2画面の起動
            startActivity(intent);
        }

    }
}
