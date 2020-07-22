package com.example.wirelesscaliper2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class NetworkServer implements Runnable {


    @Override
    public void run() {
        while (true){

            try {
                byte[] bytes = new byte[120];
                String string = "";

                DatagramSocket datagramSocket = new DatagramSocket(3333);

            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);

           datagramSocket.receive(datagramPacket);
            datagramSocket.close();

                    string = new String(bytes);





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
