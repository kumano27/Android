### Android の XML ファイル  
** AndroidMainfest.xml ** とはAndroidアプリケーションを実行するために必要な情報を登録、管理するためのファイルの事。  
AndroidManifast.xml は ** マニフェストファイル ** と呼ばれることがある。  

マニフェストファイルには Android アプリケーションの実行に必要な以下の情報が記録される。  
・アプリケーションが使用するコンポーネント  
・標準のライブラリ以外に使用するライブラリの情報  
・パーミッションの設定情報  
・想定している Android のバージョン情報  


プロジェクト作成後の AndroidManifest.xml は、以下のような状態。  

```  
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.test">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```  

①<?xml version="1.0" encoding="utf-8"?>  
「<?xml」と「?>」で囲まれたタグは、XMLの宣言部。  
ここでの使用バージョンは「1.0」、文字コードが「utf-8」であることが示されている。  

②<manifest xmlns:android="http://schemas.android.com/apk/res/android"  
ネームスペース（名前空間名）「android」を示す。  
XMLでは、独自の属性名を使用することが出来る。  
これを区別するための仕組みがネームスペース。  
ネームスペースは、パッケージ名のように、同じ名前のタグが存在しても区別できるようにするためのもの  

③package="com.example.test"  
このアプリのパッケージ名が「com.example.test」であることを示す。  

④<application  
アプリケーションの実行に必要なコンポーネントの情報を記述。  
アクティビティ、サービス、コンテンツプロバイダー、ブロードキャストレシーバ―の各コンポーネントは以下のエレメントを使って記述  

|　|　|  
|:-:|:-:|  
|activity|アクティビティに関する情報を記述|
|service|サービスに関する情報を記述|
|provider|コンテンツプロバイダーに関する情報を記述|
|receiver|ブロードキャストレシーバ―に関する情報を記述|

アクティビティに関する情報が下の行の＜action＞～＜/actionaction＞  

⑤android:allowBackup="true"  
バックアップサービスを利用するかどうかを指定する。  
true(使用する) or false(使用しない)  
デフォルトはtrue  

⑥android:icon="@mipmap/ic_launcher"  
「android:icon」属性でアプリケーションのアイコンを設定している。  
「@mipmap/ic_launcher」は、アプリケーション名がリソース用フォルダー「res」→「values」内のリソースファイル「strings.xml」に、アプリケーション名が保存されていることを表す。  
