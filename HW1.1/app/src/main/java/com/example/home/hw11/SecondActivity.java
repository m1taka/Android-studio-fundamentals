package com.example.home.hw11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by HOME on 2.9.2016 г..
 */
public class SecondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.second_activity_layout);
        Intent intent = this.getIntent();

        TextView mTextView = (TextView) findViewById(R.id.textView2);

        String info = intent.getStringExtra("info");

        mTextView.setText(info);
    }
}
