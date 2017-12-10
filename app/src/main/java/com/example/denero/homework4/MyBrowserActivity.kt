package com.example.denero.homework4

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.web_browser.*


/**
 * Created by DENERO on 10.12.2017.
 */
class MyBrowserActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_browser)
        webView.webViewClient = WebViewClient()
        var data = intent.getStringExtra("link")
        var uri = Uri.parse(data)
        webView.loadUrl(data)
    }
}