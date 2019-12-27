package com.example.wirelesscaliper2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetworkServer implements Runnable {
   byte[] bytes = new byte[8];
   String string;
    @Override
    public void run() {
        while (true){

            try {
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
                string = "";




            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
