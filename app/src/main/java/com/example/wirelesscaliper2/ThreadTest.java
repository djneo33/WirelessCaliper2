package com.example.wirelesscaliper2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ThreadTest implements Runnable {
    @Override
    public void run() {
        int x = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            x++;
            Handler handler = MainActivity.handler;
            Bundle bundle = new Bundle();
            Message message = new Message();


            bundle.putString("key1",Integer.toString(x));
            message.setData(bundle);

            handler.sendMessage(message);
            if (MainActivity.aSwitch.isChecked()) {
                try {
                    byte[] bytes = new byte[20];
                    bytes = "heeee".getBytes();

                    DatagramSocket datagramSocket = new DatagramSocket();
                    datagramSocket.send(new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.2.31"), 3336));

                    datagramSocket.close();
                } catch (SocketException | UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
