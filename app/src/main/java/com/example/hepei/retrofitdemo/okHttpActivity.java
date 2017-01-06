package com.example.hepei.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class okHttpActivity extends Activity implements View.OnClickListener {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        btn = (Button) findViewById(R.id.btn_okhttp);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_okhttp:
                // 初始化
                OkHttpClient okHttpClient = new OkHttpClient();
                // 请求的构建
                Request request = new Request.Builder()
                        .get()// Get请求的方式
                        .url("http://www.baidu.com")
                        .header("Accept-Cherset", "utf-8")
                        .header("X-type", "json")
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    //onfailure:请求失败，后台线程
                    public void onFailure(Call call, IOException e) {
                        Log.d("Tag", "请求失败");
                    }

                    @Override
                    // onResponse：请求成功，后台线程，只要响应码：1XX--5XX
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i("Tag", "请求成功"+response.body().string());
                    }
                });
                break;
        }
    }
}
