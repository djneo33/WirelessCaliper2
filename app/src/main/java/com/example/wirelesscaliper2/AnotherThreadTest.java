package com.example.wirelesscaliper2;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
public class AnotherThreadTest implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x = 5000;
        Handler handler = MainActivity.handler;
        Bundle bundle;
        Message message;
        while (true) {
            x--;
            bundle = new Bundle();
            bundle.putString("key3", Integer.toString(x));
            message = new Message();
            message.setData(bundle);
            handler.sendMessage(message);
            if (x <= 0) {
                x = 5000;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
