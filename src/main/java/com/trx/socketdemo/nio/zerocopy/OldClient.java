package com.trx.socketdemo.nio.zerocopy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost",8080);
        InputStream inputStream = new FileInputStream("test.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        int readCount=0;
        long total=0;
        long startTime = System.currentTimeMillis();

        while((readCount=inputStream.read(buffer))>=0){

            total +=readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("发送总字节数："+total+",耗时："+(System.currentTimeMillis()-startTime));
        dataOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
