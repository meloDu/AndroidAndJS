package com.rmtd.melo.androidandjs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取webview控件
        mWebView = (WebView) findViewById(R.id.webview);
        // 获取WebView的设置
        WebSettings webSettings = mWebView.getSettings();
        // 将JavaScript设置为可用，这一句话是必须的，不然所做一切都是徒劳的
        webSettings.setJavaScriptEnabled(true);
        //给webview添加JavaScript接口
        mWebView.addJavascriptInterface(new JsInterface(), "control");
        //通过webview加载html页面
        mWebView.loadUrl("file:///android_asset/jsbutton.html");
    }

    public class JsInterface {
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
            Log.d("html", "show toast success");

            log("android调用了js");
        }

        public void log(final String msg) {
            mWebView.post(new Runnable() {

                @Override
                public void run() {
                    //androdi 调用js
//                    mWebView.loadUrl("javascript log(" + "'" + msg + "'" + ")");

                }
            });
        }

        @JavascriptInterface
        public void goThere(String jingdu, String weidu) {
            Log.d("html", "js调用了android   ，goThere  success:" + jingdu + "," + weidu);



        }
    }
}
