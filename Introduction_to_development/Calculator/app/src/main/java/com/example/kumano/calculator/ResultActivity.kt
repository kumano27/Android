package com.example.kumano.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 入力画面でInsertに詰めた値を取り出す
            // intent プロパティ　アクティビティに使用されたIntent。getIntExtra()やgetStringExtra()などその型に応じたメソッドで取り出すことが出来る。
            // getIntExtra()
                // 第1引数 画面遷移を行う時にIntent.putExtra()で値を追加した際に使ったキー
                // 第2引数 キーに対応する値が存在しなかった場合に返されるデフォルト値
        val price = intent.getIntExtra("price",0)
        val discount = intent.getIntExtra("discount", 0)

        // テキストビューへの反映
        val expression = findViewById<TextView>(R.id.expression_label)
        expression.text = getString(R.string.expression, price, discount)

        // 割引後の価格を計算
        val discountedPrice = price * (100 - discount) / 100

        val result = findViewById<TextView>(R.id.result_label)
        result.text = getString(R.string.result, discountedPrice)
    }
}
