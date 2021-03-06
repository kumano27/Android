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
"void" このメソッドは処理を実行するだけと示す修飾子。  
メソッドにはただ処理だけを行うもの、処理を行って結果を呼び出し元にかえすものがあるのでどのタイプのメソッドであるかここで示す決まりになっている。  
「onCreate」がメソッド名。メソッド名のあとの()は、このメソッドが呼び出される時に受け取るデータを示す部分。  
ここには前回アクティビティを終了したときの状況を受け取るための記述がある。  

メソッドの1行目末尾の「{」から「}」までの部分がメソッドの本体で、ここにメソッドが行う処理を書いていく。  
今回の例では、既に2行分のコードが記述されているが、これはアクティビティを作成して画面に表示する為のメソッドを呼び出すためのコード。  
従って、アクティビティに何らかの機能(配置されたボタン押下等)を組み込む場合は3行目以降にソースコードを記述することになる。  


#### アプリを動かすためにやるべきこと(クラスのインスタンス化)  
Javaプログラミングの基本はクラス。  
プログラムは「データを入れておく為の箱」としての変数と、  
「○○を××せよ」という命令文で成り立つ。  
更に、命令文の場合は関連する命令文を1つにまとめて名前を付ける。  
一般的に関数と呼ばれたりするが、クラスの中に書かれた関数はメソッドと呼ばれる。  

Javaプログラムは、すべてクラスと呼ばれる単位で作られている。  
クラスにはデータを入れて置く為の変数(クラスで使う変数をフィールドと呼ぶ事もある)、処理を行う為の命令文をまとめたメソッドが含まれている。  
これら以外にも細々としたものが含まれていることもあるが先ずは2つを押さえておけば良い。  

JDKやAndroid SDKにはライブラリー形式で、JavaやAndroidの開発元が作成した膨大な数のクラスが収録されている。  
このようなクラス群をまとめてAPI(Application Programming Interface)と呼ぶ。  
JavaのAPIは「Android API」と呼ばれる。  
これらのAPIの中からやりたい事を実行してくれるクラスを呼び出して、何らかの処理を行わせることが、Androidプログラミングのスタイル。  
独自のクラスを作成する事も可能だが、先ずは  
「データを用意」⇒「クラス呼び出し」⇒「何らかの処理を行う」  
上記の基本を押さえる。  

■ クラスを呼び出す理由  
例として印刷処理について考える。  
「印刷するデータを取り込む」→「用紙を送る」→「フォントや文字サイズを設定する」→「プリントを開始する」  
上記のような手順になる(とする)。このような場合は、印刷に関連する処理を行うAPIをライブラリーから呼び出す。  
ライブラリーとは、クラスのように何らかの処理を行うプログラムがまとめられたファイルのこと。  
JavaのSDKやAndroid SDKのライブラリーにはクラス(API)別にパッケージごとにまとめられている。  
当然だが、すべてのクラスがJavaで作られていて、既にコンパイル(実行コードへの変換)が済んでいるでパッケージ名とクラス名を指定すれば呼び出せるようになっている。  

クラスを呼び出すと、クラスに含まれているメソッドが使用可能となる。  
印刷関連のクラスには「印刷するデータを読み込む」～「プリントを開始する」までに至る処理を行うメソッドが用意されいるので、  
それらのメソッドを順番に呼び出すコードを追記する事で何らかのデータをプリントアウトする機能をアプリケーションに搭載する事が可能。  

■　クラスを呼ぶには？  
クラスを呼び出すには、あらかじめ決められている手順(仕様)に従ってコードを入力する。  
文書ファイルや画像データを呼び出す操作を行と、ハードディスクから必要なデータがメモリに読み込まれる。  
クラスの場合も同様。クラス本体はハードディスクにあるので、あらかじめ必要なメモリ領域を用意しておいて、そこへクラスを読み込む。  

#### クラスを呼び出す構文(クラスのインスタンス化)  
インスタンスとは、メモリ上に読み込まれたクラスのデータの事を指す。  
クラスを呼び出してインスタンスにするので「インスタンス化」という言い方をする。  
Javaを始めとするオブジェクト指向プログラミング言語では、  
まず「クラスのインスタンス化」→「処理」という流れでプログラミングを始める。  

クラスを呼び出すには、 new 演算子を使い以下のように記述する。  

```java
クラス名 参照変数名 = new クラス名();
```

・クラス名 参照変数名  
クラスをメモリに読み込んだとして、その領域がどこだかわからないと、読み込んだ後の処理ができない。  
読み込んだ領域に名前(参照変数名)を付けておく。名前の前にクラス名を置けば、そのクラスを読み込む為の適切なメモリ領域が用意される。  

・=  
プログラミングにおける「=」は、右辺の値を左辺に代入する役割(代入演算子)。  

・new クラス名  
"new クラス名" でクラスが呼び出されるので、呼び出したクラスを「=」の左辺の参照変数が示すメモリ領域に格納する。  
newはクラスを呼び出してメモリに読み込むことを指示する演算子。  
呼び出したクラスを参照変数に格納してしまえば、  
参照変数名を支持することでいつでもメモリに格納されたクラスの情報にアクセスする事が可能。  
ここでの「アクセス」とは、  
クラスが持っているフィールドの値を参照したり、クラスのメソッドを呼び出す事を指す。
