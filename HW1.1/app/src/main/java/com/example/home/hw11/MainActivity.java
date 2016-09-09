package com.example.home.hw11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  implements View.OnClickListener,View.OnLongClickListener {

    Button mBtn, mBtn2, mBtn3;
    TextView mTextView;
    int mButtonPressed = (R.id.button);
    int mButtonPressed2 = (R.id.button2);
    int mButtonPressed3 = (R.id.button3);
    private static int lastID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);

        mBtn = (Button) findViewById(R.id.button);
        mBtn2 = (Button) findViewById(R.id.button2);
        mBtn3 = (Button) findViewById(R.id.button3);

        mBtn.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mTextView.setOnClickListener(this);

        mBtn.setOnLongClickListener(this);
        mBtn2.setOnLongClickListener(this);
        mBtn3.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        //Първи бутон: Пешо
        if (view.getId() == R.id.button) {
            if (mBtn != null)
                mTextView.setText(String.valueOf(mBtn.getText()));
            lastID = mBtn.getId();
        }

        //Втори бутон: Гошо
        if (view.getId() == R.id.button2) {
            if (mBtn2 != null)
                mTextView.setText(String.valueOf(mBtn2.getText()));
            lastID = mBtn2.getId();
        }

        //Трети бутон: Тошо
        if (view.getId() == R.id.button3) {
            if (mBtn3 != null)
                mTextView.setText(String.valueOf(mBtn3.getText()));
            lastID = mBtn3.getId();
        }
        return false;
    }

    @Override
    public void onClick(View view) {

        //Първи бутон: Пешо
        if (view.getId() == R.id.button) {
            if (mBtn != null)
                mTextView.setText(String.valueOf(mButtonPressed));
            lastID = mBtn.getId();
        }

        //Втори бутон: Гошо
        if (view.getId() == R.id.button2) {
            if (mBtn2 != null)
                mTextView.setText(String.valueOf(mButtonPressed2));
            lastID = mBtn2.getId();
        }

        //Трети бутон: Тошо
        if (view.getId() == R.id.button3) {
            if (mBtn3 != null)
                mTextView.setText(String.valueOf(mButtonPressed3));
            lastID = mBtn3.getId();
        }

        //Component ID and Name
        if (lastID == -1) {
            return;
        }
        int cmtID = lastID;
        String cmtName = ((Button) this.findViewById(cmtID)).getText().toString();
        String info = String.format("ID: %s%nName: %s", cmtID, cmtName);

        if (view.getId() == R.id.textView) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("info", info);

            startActivity(intent);
        }
    }
}






