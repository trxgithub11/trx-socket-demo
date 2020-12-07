package com.trx.socketdemo.nio.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){

            Socket  client = serverSocket.accept();
            DataInputStream  dataInputStream = new DataInputStream(client.getInputStream());

            try{

                byte[]  byteArray = new byte[4096];
                while(true){

                    int readcount = dataInputStream.read(byteArray,0,byteArray.length);
                    if(-1==readcount){

                        break;
                    }
                }
            }catch (Exception e){

//                e.printStackTrace();
            }
        }

    }
}
