package com.example.kumano.calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // onCreate() アクティビティが生成されたときに呼ばれるコールバックメソッド。必須。
        // super.onCreate() スーパークラスのonCreate()を呼んでいる。アクティビティのライフサイクルに関わるコールバックメソッドの多くは、スーパークラスのメソッドを呼ぶことを要求する。
        super.onCreate(savedInstanceState)

        // setContentView() このアクティビティで使用するレイアウトファイルを指定。レイアウトファイルではなく、ビューやビューグループをアクティビティの表示すべき内容として直接設定可能だがあまり行わない。
        setContentView(R.layout.activity_main)

        // ボタンへの参照
            // findViewById() IDを指定することでアクティビティに設置されたビューやビューグループへの参照を取得するメソッド
                // <Button> 参照するビューの型を指定するもの
        val button = findViewById<Button>(R.id.calculate)

        // クリックイベントリスナー
        button.setOnClickListener {
            // ここに任意の処理を実装する

            // 妥当性確認
            var isValid = true

            // エディットテキスト(price)の参照
            val priceEditText = findViewById<EditText>(R.id.price)
            // エディットテキストから入力されている値取得
                // EditText クラス、text プロパティ
                    // priceEditText.text 現在入力されている値
                    // toString() textプロパティは Editable 型で、そのまま整数型に変換することが出来ない。その為 toString()メソッドで String型に変換
            val priceText = priceEditText.text.toString()

            if(priceText.isEmpty()){
                // 定価が未入力
                priceEditText.error = getString(R.string.price_error)
                isValid = false
            }

            // エディットテキスト(discount)の参照
            val discountEditText = findViewById<EditText>(R.id.discount)
            // エディットテキストから入力されている値取得
            val discountText = discountEditText.text.toString()

            if(discountText.isEmpty()){
                // 割引率が未入力
                discountEditText.error = getString(R.string.discount_error)
                isValid = false
            }

            if(isValid){
                // 文字列を整数型に変換
                val price = Integer.parseInt(priceText)
                val discount = Integer.parseInt(discountText)

                // ここで画面遷移
                // Intentを明示的インテントとして生成
                val intent = Intent(this, ResultActivity::class.java)

                // 起動するコンポーネントに渡す値を持たせる
                    // putExtra() 起動するコンポーネントで使用する値をKey-Value形式で渡すためのメソッド
                intent.putExtra("price", price)
                intent.putExtra("discount", discount)
                // 遷移先アクティビティから結果を受け取らない遷移方法(遷移先アクティビティから結果を受け取る遷移方法 -> startActivityForResult())
                startActivity(intent)
            }
        }
    }
}
