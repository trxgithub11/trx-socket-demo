package com.trx.socketdemo.datastructures.sparsearray;

import java.io.*;

public class SparseArray {

    public static void main(String[] args) throws Exception{
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1表示黑子 2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][5]=2;
        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //将二维数组转稀疏数组的思路
        //1、先遍历二维数组得到非0数据的个数
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }

        System.out.println("非0的个数="+sum);


        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count=0;//count用于记录是第几个非0数据
        for(int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }


        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();


        //稀疏数组文件存储
        System.out.println("稀疏数组数据存储到文件...");
        FileOutputStream  outputStream = new FileOutputStream("sparse.txt");

        byte[] datas  = new byte[1024];

        for (int i=0;i<sparseArr.length;i++){

            datas = (String.valueOf(sparseArr[i][0])+"\t"+String.valueOf(sparseArr[i][1])+"\t"+String.valueOf(sparseArr[i][2])+"\n").getBytes();
            outputStream.write(datas);
        }


        outputStream.close();


        //从文件中恢复原始数组数据

        System.out.println("文件系统恢复原始二维数组数据");

        BufferedReader   bufferedReader = new BufferedReader(new FileReader("sparse.txt"));
        int[][] chessArr2 = null;
        int b = 0;
        while(true){

            b++;
            String content =  bufferedReader.readLine();

            if(content==null){
                break;
            }
            if(b==1){
                String[] a = content.split("\t");
                int c = Integer.parseInt(a[0]);
                int d = Integer.parseInt(a[1]);
                chessArr2 = new int[c][d];
            }else {

                String[] g = content.split("\t");
                int e = Integer.parseInt(g[0]);
                int f = Integer.parseInt(g[1]);
                int value = Integer.parseInt(g[2]);
                chessArr2[e][f] = value;
            }
            System.out.println(content);
        }
        bufferedReader.close();





        //将稀疏数组-->恢复成原始的二维数组
        /**
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int[11][11]
         * 2.在读取稀疏数组后几行的数据，并赋给原始的二维数组  即可。
         */
        //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
//        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.在读取稀疏数组后几行的数据（从第二行开始）并赋给原始的二维数组 即可

//        for(int i=1;i<sparseArr.length;i++){
//            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
//        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for(int[] row : chessArr2){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



    }
}
