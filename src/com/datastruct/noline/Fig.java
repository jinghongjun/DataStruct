package com.datastruct.noline;

import java.util.Scanner;

/*
图
    图结构也是一种非线性数据结构
    研究图结构的一个专门理论工具便是图论
    图结构包括两部分：
        顶点：图中的数据元素
        边：图中连接这些顶点的线
        所有的顶点构成一个顶点集合（V（G）），所有的边构成边集合（E（G）），一个完整的图结构就是由顶点集合和边集合组成的（G=（V，E））。
    注意：图结构中顶点集合必须为非空，即必须包含一个顶点，而图结构中边集合可以为空。
    
基本概念

    1.无向图
        如果一个图结构中，所有的边都没有方向性，那么这种图便称为无向图
        一条边可以用（v1,v5）或（v5,v1）表示
        
    2.有向图
        如果一个图结构中，边是有方向性的，那么这种图便称为有向图。这样，我们在表示边的时候对两个顶点的顺序有要求，并且为了同无向边区分
，这里我们采用尖括号表示有向边<v3,v4>

    3.顶点的度
        连接顶点的边的数量称为该顶点的度。顶点的度在有向图和无向图中具有不同的表示。
        对于无向图，一个顶点V的度比较简单，其是连接该顶点的边的数量，记为D（V）。
        对于有向图，根据连接顶点V的边的方向性，一个顶点的度有入度（以该顶点为端点的入边数量,ID(V)）和出度（以该顶点为端点的出边数量,OD(V)）之分。这样
有向图中，一个顶点V的总度便是入度和出度之和，即D(V)=ID(V)+OD(V);

    4.邻接顶点
        邻接顶点是指图结构中一条边的两个顶点。邻接顶点在有向图和无向图具有不同的表示
        对于无向图，邻接顶点比较简单。
        对于有向图，根据连接顶点V的边的方向性，两个顶点分别称为起始顶点和结束顶点。有向图的邻接顶点分为两类：
            入边邻接顶点：连接该顶点的边中的起始顶点。
            出边邻接顶点：连接该顶点的边中的结束顶点。
            
    5.无向完全图
        如果在一个无向图中，每两个顶点之间都存在一条边，那么这种图结构称为无向完全图。对于一个包含N的顶点的无向完全图，其总的边数N(N+1)/2
        
    6.有向完全图
        如果一个有向图，每两个顶点之间都存在方向相反的两条边，那么这种图结构成为有向完全图。对于一个包含N的顶点的有向弯曲图，其总的边数N(N-1)
    
    7.子图
        子图的概念类似的子集合，由于一个完整的图结构包括顶点和边，因此，一个子图的顶点和边都应该是另一个图结构的子集合。这里需要强调
的是，只有顶点集合是子集的，或者只有边集合是子集，都不是子图。

    8.路径
        路径就是图结构中两个顶点之间的连线。
        图结构中的路径还可以细分
            简单路径
            环
            简单回路
     
     9.连通、连通图和连通分量
         连通:如果图结构中两个顶点之间有路径，则称这两个顶点是连通的。这里需要注意连通的两个顶点可以不是邻接顶点，只要有路径连接即可，可以途径多个顶点
         连通图：如果无向图中任意两个顶点都是连通的，那么这个图便称连通图。否则反之。
         连通分量：无向图的极大连通子图称为该图的连通分量
         
     10.强连通图和强连通分量
        这个概念类似无向图，这个针对有向图而言的。
        
     11.权
         在实际的应用中往往需要将边表示成某种数值，这个数值便是该边的权。无向图中加入权值，则称为无向带权图，有向图加入权值，则称为有向带权图。
         权在实际应用中可以代表各种含义，例如在交通图中表示了道路的长度，在通信网络中表示基站之间的距离，在人际关系中代表亲密程度。
     
     12.网
         网就是边上带有权值的图的另一种名称。
         
     在实际应用中，通常需要采用结构数组的形式来单独保存顶点信息，然后采用二维数组的形式保存顶点之间的关系。这种保存顶点之间关系的数组称为邻接矩阵。
        
 */

class GraphMatrix{
    //图的最大顶点数
    static final int MAXNUM = 20;
    //最大值
    static final int MAX_VALUE = 65535;
    
    //保存顶点信息（序号或字母）
    char[] mVertex = new char[MAXNUM];
    //图的类型：0：无向图； 1：有向图
    int mGType;
    //顶点的数量
    int mVertexNum;
    //边的数量
    int mEdgeNum;
    //保存边的权
    int[][] mEdgeWeight = new int[MAXNUM][MAXNUM];
    //遍历标志
    int[] isTrav = new int[MAXNUM];
    

}



public class Fig {
    
    /**
     * 清空图就是将一个图结构变成一个空图，这里只需将矩阵中各元素设置为MAX_VALUE即可。
     * @param gm：指向图结构的引用
     */
    static void clearGraph(GraphMatrix gm){
        int i,j;
        //清空矩阵
        for (i = 0; i < gm.mEdgeNum; i++) {
            for (j = 0; j < gm.mEdgeNum; j++) {
                //设置矩阵中各元素的值为最大值
                gm.mEdgeWeight[i][j] = GraphMatrix.MAX_VALUE;
            }
        }
    }
    
    /**
     * 显示图就是显示图的邻接矩阵，用户可以通过邻接矩阵方便地了解图的顶点和边等结构信息
     * 在程序中，首先在第1行输出顶点信息，然后，逐个输出矩阵中的每个元素，这里，以Z表示无穷大
     * @param gm：指向图结构的引用
     */
    static void outGraph(GraphMatrix gm){
        int i,j;
        for (j = 0; j < gm.mVertexNum; j++) {
            //在第1行输出顶点信息
            System.out.printf("%c",gm.mVertex);
        }
        for (i = 0; i < gm.mVertexNum; i++) {
            System.out.printf("%c", gm.mVertex[i]);
            for (j = 0; j < gm.mVertexNum; j++) {
                //若权值为最大值
                if (gm.mEdgeWeight[i][j] == GraphMatrix.MAX_VALUE) {
                    //以Z表示无穷大
                    System.out.println("Z");
                } else {
                    //输出边的权值
                    System.out.printf("%d", gm.mEdgeWeight[i][j]);
                }
            }
        }
    }
    
    /**
     * 创建图 在程序中，由用户输入顶点信息和边的信息。对于边来说，需要输入起始顶点、结束顶点和权值，各项以空格分割，最后，判断是否为
     * 无向图，以为无向图还需将边的权值保存到对角位置
     * @param gm：指向图结构的引用
     */
    static void createGraph(GraphMatrix gm){
        int i,j,k;
        //权
        int weight;
        //边的起始顶点
        char eStartV, eEndV;
        Scanner input = new Scanner(System.in);
        
        //输入顶点
        System.out.println("输入图中各顶点信息");
        for (i = 0; i < gm.mVertexNum; i++) {
            System.out.printf("第%d个顶点：", i + 1 );
            //保存到各顶点数组元素中
            gm.mVertex[i] = (input.next().toCharArray()[0]);
        }
        
        //输入边的信息
        System.out.println("输入构成各边的顶点及权值：");
        for (k = 0; k < gm.mEdgeNum; k++) {
            System.out.printf("第%d条边： ", k + 1);
            eStartV = input.next().charAt(0);
            eEndV = input.next().charAt(0);
            weight = input.nextInt();
            //在已有顶点中查找开始点
            for (i = 0; eStartV != gm.mVertex[i]; i++);
            //在已有顶点中查找终点
            for(j=0; eEndV != gm.mVertex[j]; j++);
            //对应位置保存权值，表示有一条边
            gm.mEdgeWeight[i][j] = weight;
            //若是无向图
            if (gm.mGType == 0) {
                //在对角位置保存权值
                gm.mEdgeWeight[i][j]=weight;
            }
        }
    }
    
    /**
     * 遍历图就是逐个访问图中所有的顶点。
     * 常用的图遍历方法有两种：广度优先法和深度优先法，我们这里一深度优先遍历算法为例，深度优先类似于树的先序遍历
     * 程序从第n个结点开始深度遍历图
     * @param gm:指向图结构的引用
     * @param n:顶点编号
     */
    static void deepTraOne(GraphMatrix gm, int n){
        int i;
        //标记该顶点已处理过
        gm.isTrav[n] = 1;
        System.out.printf("->%c", gm.mVertex[n]);
        
        //添加处理节点的操作
        for (i = 0; i < gm.mVertexNum; i++) {
            if (gm.mEdgeWeight[n][i] != GraphMatrix.MAX_VALUE && gm.isTrav[n] == 0) {
                //递归进行遍历
                deepTraOne(gm, i);
            }
        }
        
    }
    
    /**
     * 
     * @param gm:指向图结构的引用
     * @param n:顶点编号
     * @param ch:待查找的顶点
     */
    static void deepTraOne(GraphMatrix gm, int n, char ch){
        int i;
        //标记该顶点已处理过
        gm.isTrav[n] = 1;
        //判断
        if (gm.mVertex[n] == ch) {
            //输出结点数据
            System.out.printf("->%c", gm.mVertex[n]);
        }
        //添加处理结点的操作
        for (i = 0; i < gm.mVertexNum; i++) {
            if (gm.mEdgeWeight[n][i] != GraphMatrix.MAX_VALUE && gm.isTrav[n] == 0) {
                //递归进行遍历
                deepTraOne(gm, i, ch);
            }
        }
    }

    /**
     * 用于执行完整的深度优先遍历，以访问所有的顶点
     * @param gm
     */
    static void deepTraGraph(GraphMatrix gm){
        int i;
        //清除各顶点遍历标志
        for (i = 0; i < gm.mVertexNum; i++) {
            gm.isTrav[i] = 0;
        }
        
        System.out.println("深度优先遍历结点：");
        for (i = 0; i < gm.mVertexNum; i++){
            //若该点未遍历
            if (gm.isTrav[i] == 0) {
                //调用函数遍历
                deepTraOne(gm, i);
            }
        }

    }

    public static void main(String[] args) {

        //定义保存邻接表结构的图
        GraphMatrix gm = new GraphMatrix();
        
        System.out.println("输入生成图的类型：");
        Scanner input = new Scanner(System.in);
        //图的种类
        gm.mGType = input.nextInt();
        
        System.out.println("输入图的顶点数量:");
        //输入图顶点数
        gm.mVertexNum = input.nextInt();
        
        System.out.println("输入图的边数量: ");
        //输入图边的数量
        gm.mEdgeNum = input.nextInt();
        
        //清空图
        clearGraph(gm);
        //生成邻接表结构的图
        createGraph(gm);
        System.out.println("该图的邻接矩阵数据如下: ");
        //输出邻接矩阵
        outGraph(gm);
        //深度优先搜索遍历图
        deepTraGraph(gm);
    }

}
