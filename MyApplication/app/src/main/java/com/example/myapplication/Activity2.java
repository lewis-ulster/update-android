package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

       /* WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("http://www.ulster.ac.uk"); */
    }

    public void webSearch(View view){
        String searchFor = ((EditText) findViewById(R.id.editText)) .getText().toString();
        Intent viewSearch = new Intent (Intent.ACTION_WEB_SEARCH);
        viewSearch.putExtra(SearchManager.QUERY, searchFor);
        startActivity(viewSearch);
    }

    private boolean checkPermission(String permission){
    int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
    return (permissionCheck == PackageManager.PERMISSION_GRANTED);
    }

    public void dialPhone(View view){
        if(checkPermission("android.permission.CALL_PHONE")) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:07843171803"));
            startActivity(intent);
        }
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Activity2.this, sendText.class);
        startActivity(intent);
    }
}
