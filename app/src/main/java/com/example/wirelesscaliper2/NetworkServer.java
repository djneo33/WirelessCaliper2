package com.example.wirelesscaliper2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetworkServer implements Runnable {


    @Override
    public void run() {
        while (true){

            try {
                byte[] bytes = new byte[8];
                String string = "";

                DatagramSocket datagramSocket = new DatagramSocket(3333);

            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

           datagramSocket.receive(datagramPacket);
            datagramSocket.close();
                for (int i = 0; i < bytes.length; i++) {
                   if (bytes[i] != 0){
                       string = string+ (char) bytes[i];
                   }

                }
                System.out.println(string);
                Handler handler = MainActivity.handler;
                Bundle bundle = new Bundle();
                bundle.putString("key",string);
                Message message = new Message();
                message.setData(bundle);
                handler.sendMessage(message);












            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
