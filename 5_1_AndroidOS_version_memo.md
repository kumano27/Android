## Android OSのバージョンを画面に表示してみる  
Android OSは、Linux OSを基幹部分として使用している。  
Linuxでは、CPUやメモリなどのシステムリソースの使用状況を「/proc」以下のディレクトリ(WindowsやMacのファルダーに相当)にファイルとして保存。  
ただし、実際にファイルが存在するのではなく、「仮想的」なファイルだが、通常のファイル同様アクセス可能。  


/proc 以下には、いくつものファイルが存在。これらのファイルはそれぞれ目的に応じた情報が格納されている。  

表1. /proc に格納されている情報

|ファイル名|内容| 
|:--:|:--|
|/proc/version|Linuxカーネルのバージョン|
|/proc/cpuinfo|CPUに関する情報|
|/proc/uptime|システムの稼働時間|
|/proc/acpi|電源管理に関する情報|
|/proc/device|使用可能なデバイス|
|/proc/cmdline|カーネルのコマンドライン|
|/proc/dma|DMAチャンネル情報|
|/proc/filesystems|使用可能なファイルシステム|
|/proc/interrupts|割り込み情報|
|/proc/ioports|I/Oポート情報|
|/proc/kmsg|カーネルのメッセージ|
|/proc/loadavg|負荷情報|
|/proc/locks|カーネルがロックしているファイル|
|/proc/meminfo|メモリに関する情報|
|/proc/module|カーネルにロードされたモジュールの一覧|
|/proc/mounts|マウントされたファイルシステムの一覧|
|/proc/stat|システムが最後に再起動された時以降のシステム全体の統計情報|
|/proc/sys|ネットワークやファイルアクセスなどの設定を含むディレクトリ|
|/proc/net|ネットワークに関する設定を含むディレクトリ|
|/proc/bus|パスの情報を含むディレクトリ|

/proc に格納されているファイルにはそれぞれの情報が文字列として保存されている。  

### 1.アプリ画面作成  
新規プロジェクト「DispKernelInfo」を作成。(サンプルの為変更可能)  
アクティビティ名：MainActivity　⇒　Javaリソースファイル：MainActivity.java  
レイアウトファイル：activity_main　⇒　XML：activity_main.xml  

Projectウィンドウから app → src → main → res → layout を展開し、activity_main.xml をダブルクリック。  
DesignタブをクリックするとDesignエディターが表示される。    
プロジェクトを作成時に「Hello world!」と表示されるアプリが自動で作成されている。  
今回は「Hello world!」と表示させる目的では無い為このテキストビューを削除。 

新しいテキストビューを配置する。  
レイアウト画面の左側にあるPallet → Text → TextView を選択し、  
レイアウト画面の左上の角にドラッグする。  
ドラッグ時緑色の枠が表示されるので、この枠の中に入れる。  
枠からはみ出すとレイアウトが崩れてしまうので注意。  

テキストビューを配置すると、デフォルトで「TextView」という文字が表示される。  
この文字は、この後Android OSのバージョンを表示するようプログラミングする。  
気になるようであればレイアウト画面右側のPropertiesウィンドウでtextの欄に表示されている「TextView」の文字を削除すれば、画面に表示されない。  

Propertiesウィンドウのidの欄を確認する。  
デフォルトで「textView」という名前が付けられている。  
画面上の部品の名前を設定するid属性は、「@+id/」に続けて名前の部分を記述する。  
「@+id/のあとが名前」ということを開発環境に伝えるのだが、  
[id]の入力欄に「TextView」と入力すれば、自動的に「android:id="@+id/textView"」というXMLコードが記述されるようになっている。([Text]タブにて確認可能)  

画面の作成は以上。  


### 2.ソースファイル構造確認  
Projectウィンドウのsrc → main → java → パッケージ名フォルダー → MainActivity.java を開く。  

1行目にパッケージ名を設定しているコードがある。  
続いて「import...」と記述されている部分に続く。ここにはインポート(読み込み)するパッケージを指定する為のimport分がまとめられている。  
左に見える＋ボタンはソースコードが折りたたまれていることを示す。これをクリックすると、中身が展開される。  


以下の public class MainActivity extends AppCompatActivity { } は  
アクティビティを表示する為の「MainActivity」クラス  
```java:MainActivity_class
public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
}
```  
中身は一塊のソースコードが記述されている。  
このようなコードのまとまりをコードブロックと呼ぶ。  
このコードブロックの正体はメソッド。  

#### MainActivityクラスのメソッド  
MainActivityクラスの中のコードブロックは「onCreate()」という名前のメソッド。  
メソッド名のあとに()が付いている。メソッド名を書くときは必須なので注意。  
このメソッドはAndroidアプリを起動したときに真っ先に呼び出されるメソッド。  

#### MainActivityクラスのメソッドの中身  
自動的に作成された「protected void onCreate」メソッドについて  
アクティビティを作成するためのメソッド。  
protected このメソッドは関係のないクラスからは使うことができない事を表す修飾子。  
むやみにいろいろなところから呼び出されないようにしている。  
void このメソッドは処理を実行するだけと示す修飾子。  
メソッドにはただ処理だけを行うもの、処理を行って結果を呼び出し元にかえすものがあるのでどのタイプのメソッドであるかここで示す決まりになっている。  
