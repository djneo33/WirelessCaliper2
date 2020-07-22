package com.example.wirelesscaliper2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ThreadTest2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x = 0;
        while (true){
            x++;
            Handler handler = MainActivity.handler;
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("key2", Integer.toString(x));
            message.setData(bundle);
            handler.sendMessage(message);
            if (x >= 3000){
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
