package com.trx.socketdemo.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String>  vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numofEdges;//表示边的数目
    //定义给数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited;
    public static void main(String[] args) {

        int n=9;//节点的个数
//        String Vertexs[]={"A","B","C","D","E"};
        String Vertexs[] = {"1","2","3","4","5","6","7","8","9"};

        //创建图对象
        Graph   graph = new Graph(n);
        //循环的添加顶点
        for(String vertex:Vertexs){

            graph.insertVertex(vertex);
        }

//        graph.insertEdge(0, 1, 1); // A-B
//		graph.insertEdge(0, 2, 1); //
//		graph.insertEdge(1, 2, 1); //
//		graph.insertEdge(1, 3, 1); //
//		graph.insertEdge(1, 4, 1); //
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //显示邻接矩阵
        graph.showGraph();

        System.out.println("深度遍历！");
        graph.dfs();
        System.out.println("广度优先！");
        graph.bfs();
    }

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numofEdges = 0;
    }

    //插入节点
    public void insertVertex(String vertex){

        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numofEdges++;
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.err.println(Arrays.toString(link));
        }
    }
    //深度优先遍历算法
    //i第一次就是0
    private void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点，输出
        System.out.print(getValueByIndex(i)+"->");
        //将节点设置为已经访问
        isVisited[i]=true;
        //查找结点i的第一个邻接节点w
        int w =getFirstNeighbor(i);
        while(w!=-1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w节点已经被访问过
            w=getNextNeighbor(i,w);
        }
    }

    //返回节点i（下标）对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){

        for (int j = v2+1; j < vertexList.size(); j++) {
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //如果存在就返回对应的下标，否则返回-1
    public int  getFirstNeighbor(int index){
        for (int j = 0; j <vertexList.size(); j++) {
            if(edges[index][j]>0){
                return j;
            }
        }

        return -1;
    }
    //对dfs进行一个重载，遍历我们所有的节点，并进行dfs
    public void  dfs(){
        isVisited = new boolean[vertexList.size()];
        //遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i <getNumOfVertex(); i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //遍历所有的节点，都进行广度优先搜索
    public void  bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //对一个节点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i){

        int u;//表示队列的头节点对应下标
        int w;//邻接节点w
        //队列，记录节点访问的顺序
        LinkedList  queue =  new LinkedList();
        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记为加入访问
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while(!queue.isEmpty()){
            //取出队列的头节点下标
            u=(Integer)queue.removeFirst();
            //得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);
            while(w!=-1){
                //是否访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    //标记已经访问
                    isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻节点
                w = getNextNeighbor(u,w);
            }
        }
    }
}
