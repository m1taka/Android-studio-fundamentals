package com.example.home.hw1app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    Button mBtnIncrement, mBtnIncrement2;
    TextView mTextView;
    int mButtonPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView)findViewById(R.id.textView);

        mBtnIncrement=(Button) findViewById(R.id.button);
        mBtnIncrement2=(Button) findViewById(R.id.button);
        mBtnIncrement.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.button){
            mButtonPress++;
            if(mBtnIncrement!=null)
                mTextView.setText(String.valueOf(mButtonPress));
        }
    }

    public void onButtonClicked(View view){
        mButtonPress--;
        if(mBtnIncrement2!=null)
            mTextView.setText(String.valueOf(mButtonPress));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
