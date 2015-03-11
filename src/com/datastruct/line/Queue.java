package com.datastruct.line;

import java.util.Scanner;

/*
队列：
    队列结构是从数据的运算来分类的，也就是说队列结构具有特殊的运算规则。而从数据的逻辑结构来看，队列结构就是一种线性结构。如果从数据
的存储结构来进一步划分，队列结构包括：
                           顺序结构：即使用一组地址连续的内存单元依次保存队列中的数据。在程序中，可以定义一个指定大小的结构数组
                    作为队列
                           链式结构：即使用链表形式保存队列中各元素的值
    
    在队列中允许对两端进行操作，但是两端的操作不同。在表的一端只能进行删除操作，称为队头；在表的另一端只能进行插入操作，称为队尾。
    从数据的运算角度来分析，队列结构是按照“先进先出”的原则处理结点数据
    在队列中，数据运算非常简单，一般队列结构的基本操作只有两个：
        入队列：将一个元素添加到队尾（相当于到队列最后排队等候）
        出队列：将队头的元素取出，同时删除该元素，使后一个元素成为队头
*/

//ADT
class ADT{
    String mName;
    int mAge;
}

class SQType{
    //队列长度
    static final int QUEUELEN = 15;
    //队列数组
    DATA[] mData = new DATA[QUEUELEN];
    //队头序号
    int mHead;
    //队尾序号
    int mTail;
    
    /**
     * 初始化队列，使用之前首先要创建一个空的顺序队列.首先使用new关键字申请内存，申请成功后设置队头和队尾，然后返回申请内存的首地址，
     * 如果申请失败，将返回null;
     * @return
     */
    SQType initSQType(){
        //1.按符号常量QUEUELEN指定的大小申请一片内存空间，用来保存队列中的数据
        SQType q;
        if ((q = new SQType()) != null) {
            //2.设置head=0和tail=0，表示是一个空队列
            q.mHead = 0;
            q.mTail = 0;
            return q;
        }
        return null;
    }
    
    /**
     * 判断空队列就是判断一个队列是否为空。如果是空队列，则表示该队列中没有数据。此时可以进行人队列操作，但不可以进行出队列操作。
     * 在程序中，根据队列head是否等于tail，判断队列是否为空
     * @param q:指向操作队列的引用
     * @return
     */
    int isEmptySQType(SQType q){
        int temp = 0;
        if (q.mHead == q.mTail)
            temp = 1;
        return temp;
    }
    
    /**
     * 判断满队列就是判断队列是否为满，如果是满队列，则表示队列中没有多余空间来保存额外数据。此时不可以进行入队列操作，但是可以进行
     * 出队列操作.在程序中，判断队列tail是否已等于符号常量QUEUELEN,从而判断队列是否已满
     * @param q:指向操作队列的引用
     * @return
     */
    int isFullSQType(SQType q){
        int temp = 0;
        if (QUEUELEN == q.mTail){
            temp = 1;
        }
        return temp;
    }
    
    /**
     * 释放空间是释放队列所占用的内存单元。在初始化队列结构时，使用了new关键字分配内存空间，虽然使用清空队列操作。但是清空队列操作
     * 并没有释放内存空间，这就需要使用赋值null操作释放所分配的内存
     * @param q:指向操作队列的引用
     */
    void freeSQType(SQType q){
        if (q != null) {
            q = null;
        }
    }
    
    /**
     * 入队列是队列的基本操作，主要操作是将数据元素保存到队列结构。程序中首先判断队列是否溢出，如果溢出则不进行入队列操作，否则修改
     * 队列尾引用值，在将元素入队列
     * @param q:指向操作队列的引用
     * @param data:需要入队列的数据元素
     * @return
     */
    int inSQType(SQType q, DATA data){
        //1.首先判断队列尾tail，如果tail等于QUEUELEN，则表示溢出，进行出错处理；否则执行以下操作
        if (q.mTail == QUEUELEN) {
            System.out.println("队列已满，操作失败！");
            return 0;
        } else {
            //2.设置tail = tail + 1(队列尾引用加1，指向入队列地址)
            //3.将入队列元素保存到tail指向位置
            q.mData[q.mTail++] = data;
            return 1;
        }
    }
    
    /**
     * 出队列是队列的基本操作，主要操作与入队列相反，其实从队列头弹出一个数据元素。
     * @param q:指向操作队列的引用
     * @return
     */
    DATA outSQType(SQType q){
        //1.判断队列头head,如果head等于tail，则表示为空队列，进行出错处理；否则，执行下面步骤
        if (q.mHead == q.mTail) {
            System.out.println("队列已空，操作失败！");
            return null;
        } else {
            //2.从队列首部取出队头元素（实际返回队头的引用）
            //3.修改队头head的序号，使其指向后一个元素
            return q.mData[q.mHead++];
        }
    }

    /**
     * 读结点数据也就是读取队列中结点数据。需要注意的是，读结点数据操作和出队列操作不同。读结点数据的操作是显示队列头结点数据，而出队列
     * 则将队列头数据弹出，该数据不再存在。
     * @param q:指向操作队列的引用
     * @return
     */
    DATA peekSQType(SQType q){
        if (isEmptySQType(q) == 1) {
            System.out.println("空队列！");
            return null;
        } else {
            return q.mData[q.mHead];
        }
    }
    
    /**
     * 计算队列长度就是统计该队列中数据结点的个数。计算队列长度的方法比较简单，直接队尾序号减去队头序号即可
     */
    int sqtypeLen(SQType q){
        return q.mTail - q.mHead;
    }
}



public class Queue {

    public static void main(String[] args) {
        
        SQType st = new SQType();
        DATA data1;
        
        Scanner input = new Scanner(System.in);
        
        //初始化队列
        SQType stack = st.initSQType();
        System.out.println("入队列操作：");
        
        System.out.println("输入姓名 年龄进行入队列操作：");
        do{
            DATA data = new DATA();
            data.mName = input.next();
            data.mAge = input.nextInt();
            //若输入0，则退出
            if (data.mName.equals("0")) {
                break;
            } else {
                st.inSQType(stack, data);
            }
        }while(true);
        
        String temp = "1";
        System.out.println("出队列操作：按任意非0键进行出栈操作：");
        
        temp = input.next();
        while(!temp.equals("0")){
            data1 = st.outSQType(stack);
            System.out.printf("出队列的数据是：（%s,%d）", data1.mName, data1.mAge);
            temp = input.next();
        }
        System.out.println("测试结束！");
        //释放队列所占用的空间
        st.freeSQType(stack);

    }

}
