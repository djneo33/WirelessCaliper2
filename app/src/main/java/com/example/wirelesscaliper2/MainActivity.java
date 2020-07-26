package com.example.wirelesscaliper2;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public static Handler handler;
    public TextView textView;
    public TextView textView1;
    public TextView textView2;
    public static Switch aSwitch;
    public TextView textView3;
    public ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        textView1 = findViewById(R.id.textView33);
        textView2 = findViewById(R.id.textView2);
        aSwitch = findViewById(R.id.switch1);
        textView3 = findViewById(R.id.textView4);
        progressBar = findViewById(R.id.progressBar);
    }
    @SuppressLint("HandlerLeak")
    @Override
    protected void onStart() {
        super.onStart();
        Thread thread = new Thread(new NetworkServer());
        thread.start();
        Thread thread1 = new Thread(new ThreadTest());
        thread1.start();
        Thread thread2 = new Thread(new ThreadTest2());
        thread2.start();
        Thread thread3 = new Thread(new AnotherThreadTest());
        thread3.start();
        Thread thread4 = new Thread(new ProgressbarThread());
        thread4.start();
        handler = new Handler() {
            @SuppressLint("HandlerLeak")
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String key = bundle.getString("key");
                String key1 = bundle.getString("key1");
                String key2 = bundle.getString("key2");
                String key3 = bundle.getString("key3");
                String key4 = bundle.getString("key4");
                if (key != null) {
                    System.out.println(key);
                    textView.setText(key);
                }
                if (key1 != null) {
                    textView1.setText(key1);
                }
                if (key2 != null) {
                    textView2.setText(key2);
                }
                if (key3 != null) {
                    textView3.setText(key3);
                }
                if (key4 != null) {
                    progressBar.setProgress(Integer.parseInt(key4));
                }
            }
        };
    }
}
