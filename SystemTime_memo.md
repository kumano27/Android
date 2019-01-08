#### Calendar クラス  
Java API には、システム時刻を扱うための ** Calendar ** クラスがある。  
このクラスを呼び出せば、システムが管理する日時に関する情報を得る事ができる。  

##### Calendar クラスの主な定数

|定数名|説明|
|:---:|:-:|
|ERA|ユリウス暦のAD、BC等の年代を示す|
|YEAR|年を示す|
|MONTH|月を示す|
|DATE|月の日を示す(0 ～ 11)|
|DAY_OF_MONTH|月の日を示すDATEを指定した場合と同じ|
|DAY_OF_YEAR|現在の年の何日目かを示す|
|DAY_OF_WEEK|曜日を示す|
|DAY_OF_WEEK_IN_MONTH|現在の月の何度目の曜日かを示す|
|WEEK_OF_MONTH|現在の月の何週目かを示す|
|WEEK_OF_YEAR|現在の年の何週目かを示す|
|HOUR|午前または午後の何時かを示す|
|HOUR_OF_DAY|時刻を示す|
|AM_PM|HOUR(時刻)が正午より前であるかあとであるかを示す。午前の場合は「0」、午後の場合は「1」の値が返される|
|MINUTE|分を示す|
|SECOND|秒を示す|
|MILLISECOND|ミリ秒を示す|
|ZONE_OFFSET|GMT(世界標準時)との差(オフセット)をミリ秒単位で示す|
|DST_OFFSET|夏時間の差(オフセット)をミリ秒単位で示す|
