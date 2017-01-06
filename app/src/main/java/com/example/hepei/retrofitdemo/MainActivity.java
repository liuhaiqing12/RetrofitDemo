package com.example.hepei.retrofitdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn_okthhp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_okthhp = (Button) findViewById(R.id.okhttp);
        btn_okthhp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.okhttp:
                Intent intent = new Intent();
                intent.setClass(this, okHttpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
