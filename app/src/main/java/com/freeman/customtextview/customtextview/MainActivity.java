package com.freeman.customtextview.customtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyTextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (MyTextView) findViewById(R.id.my_text_view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myTextView.cancel();
    }
}
