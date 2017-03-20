package com.freeman.customtextview.customtextview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Freeman on 09.01.2017.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private Timer timer;
    private String[] myText = {"Download    ", "Download.   ", "Download..  ", "Download... "};
    private int position = 0;
    private Handler handler;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        handler = new Handler();
        setText(myText[position++]);
        timer = new Timer();
        timer.schedule(new MyTask(), 1000, 500);
    }

    class MyTask extends TimerTask{

        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    setText(myText[position++]);
                    if (position == myText.length)
                        position = 0;
                }
            });
        }
    }
    public void cancel() {
        timer.cancel();
    }
}
