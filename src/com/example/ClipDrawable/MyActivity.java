package com.example.ClipDrawable;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView imageView=(ImageView)findViewById(R.id.image);
        final ClipDrawable drawable=(ClipDrawable)imageView.getDrawable();
        final Handler handler=new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                if(msg.what==0x1233)
                {
                    drawable.setLevel(drawable.getLevel()+200);
                }
            }
        };
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg=new Message();
                msg.what=0x1233;
                handler.sendMessage(msg);
                if(drawable.getLevel()>=10000)
                {
                    timer.cancel();
                }
            }
        },0,300);
    }
}
