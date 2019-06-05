package com.example.listviewsample2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.AlteredCharSequence;
import android.widget.Toast;

/**
 * DialogFragmentを継承したクラスを作成
 * ダイアログは様々なアクティビティから共通で利用することが多いので、privateなメンバクラスではなく、publicクラスで作成する。
 *
 * 継承元のDialogFragmentは標準パッケージとサポートライブラリの2種類がある
 * 標　準　：android.app.DialogFragment
 * サポート：android.support.v4.app.DialogFragment
 * サポートライブラリの方が適応範囲が広い
 */
public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // ダイアログビルダーを作成
        /**
         * AlertDialog クラス:Androidでダイアログを表すクラス
         * AlertDialog.Builder オブジェクト:AlertDialogオブジェクトを生成するビルダークラスのインスタンス
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // ダイアログのタイトルを設定
        /**
         * setTitle() メソッドを利用し、引数として表示文字列、もしくはそのR値を渡す。
         */
        builder.setTitle(R.string.dialog_title);

        // ダイアログのメッセージ表示
        /**
         * setMessage() メソッドを利用し、引数として表示文字列、もしくはそのR値を渡す。
         */
        builder.setMessage(R.string.dialog_msg);

        // Positive Button を設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());

        // Negative Button を設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());

        // Neutral Button を設定
        builder.setNeutralButton(R.string.dialog_btn_nu, new DialogButtonClickListener());

        // ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }

    public class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // トーストメッセージ用文字列変数を用意
            String msg = "";

            // タップされたアクションボタンで分岐
            switch(which){
                // Positive Button の場合
                case DialogInterface.BUTTON_POSITIVE:
                    // 注文用メッセージを格納
                    msg = getString(R.string.dialog_ok_toast);
                    break;

                // Negative Button の場合
                case DialogInterface.BUTTON_NEGATIVE:
                    // キャンセル用メッセージを格納
                    msg = getString(R.string.dialog_ng_toast);
                    break;

                // Neutral Button の場合
                case DialogInterface.BUTTON_NEUTRAL:
                    // 問い合わせ用メッセージを格納
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }
            // トーストの表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
