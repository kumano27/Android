package com.example.manybutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// AppCompatActivity クラスを継承し、OnClickListenerインターフェースを実装
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ((Button)findViewById(R.id.button1)).setOnClickListener(this);
            ((Button)findViewById(R.id.button2)).setOnClickListener(this);
            ((Button)findViewById(R.id.button3)).setOnClickListener(this);
        }

        private void onClickButton1(){
            ((TextView)findViewById(R.id.textView)).setText(R.string.btn1_tap);
        }
        private void onClickButton2(){
            ((TextView)findViewById(R.id.textView)).setText(R.string.btn2_tap);
        }
        private void onClickButton3(){
            ((TextView)findViewById(R.id.textView)).setText(R.string.btn3_tap);
        }

        @Override
        public void onClick(View v) {
            if(v != null){
                switch (v.getId()) {
                    case R.id.button1:
                        onClickButton1();
                        break;

                     case R.id.button2:
                         onClickButton2();
                         break;
                     case R.id.button3:
                         onClickButton3();
                         break;
                }
            }
        }

}
