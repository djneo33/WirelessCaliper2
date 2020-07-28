package com.example.wirelesscaliper2;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
public class ProgressbarThread implements Runnable {
    @Override
    public void run() {

        int x = 0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            Handler handler = MainActivity.handler;
            x++;
            if (x >= 100) {
                x = 0;
            }
            Bundle bundle = new Bundle();
            Message message = new Message();
            bundle.putString("key4", String.valueOf(x));
            message.setData(bundle);
            handler.sendMessage(message);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
