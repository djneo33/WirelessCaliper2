package com.example.wirelesscaliper2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ThreadTest implements Runnable {
    @Override
    public void run() {
        int x = 0;

        while (true){
            x++;
            Handler handler = MainActivity.handler;
            Bundle bundle = new Bundle();
            Message message = new Message();


            bundle.putString("key1",Integer.toString(x));
            message.setData(bundle);
         handler.sendMessage(message);
            if (x >= 6000){
                x = 0;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
