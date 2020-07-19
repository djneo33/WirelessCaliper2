package com.example.wirelesscaliper2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public  static Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.text);
        final TextView textView1 = findViewById(R.id.textView33);
        Thread thread = new Thread(new NetworkServer());
        thread.start();
        Thread thread1 = new Thread(new ThreadTest());
        thread1.start();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Bundle bundle = msg.getData();

                textView.setText(bundle.getString("key"));
                textView1.setText(bundle.getString("key1"));

            }
        };


    }
}
