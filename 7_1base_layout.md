### Androidアプリの開発過程  

Androidアプリの開発は、基本的に以下の順序で行う。()内はプロジェクト作成時のデフォルトファイル名  
①レイアウト作成(activity_main.xml)  
②アクティビティが表示されるときの処理を記述(MainActivity.java)
③ビューに関する処理を記述(MainActivity.java)

### レイアウトの作成について  
* XMLコード(activity_main.xml)でレイアウトを定義  
* レイアウトエディター(レイアウト用のウィンドウ)を使い間接的にXMLコードに記述
* Javaソースコード(MainActivity.java)に直接記述  

レイアウトはXML、Javaのどちらでも行えるが、  
** <font color="red">レイアウトはXML、プログラムはJavaが基本！</font> **  
保守の面からもJavaにレイアウトを埋め込まないほうが良い。  

### レイアウトビュー  
①** リニアレイアウト ** (LinearLayout)   
horizontal 属性を指定して、ビューを記述した順番で左から右方向へ、vertical 属性を指定して上から下へ並べる。  
②** テーブルレイアウト ** (TableLayout)  
テーブル(表組み)を利用したレイアウト方法。表の枡の部分にビューを配置する。ビューを格子状に並べることが出来る。  
③** 相対レイアウト ** (RelativeLayout)  
基点となるビューグループ、またはビューを指定し、それらの要素からの位置を指定してレイアウトを行う。中心となるビューがあり、その周りに他のビューを配置する場合に使用。  
④** 新たなレイアウト ** (Constraint Layout)  
Android Stutio 2.2 で追加されたレイアウトビュー。従来は複数のレイアウトビューをネスト(入れ子)しなければならないような複雑な配置を簡単に生成できるのが特徴。RelativeLayoutと似ている点もあるが、viewに制約を課してレイアウトを構築できる(RelativeLayoutはビュー同士の相対関係でレイアウトを構築する)。以下制約の例  
* 別のViewへのアンカーポイント  
* レイアウト枠  
* 目に見えないガイドライン

