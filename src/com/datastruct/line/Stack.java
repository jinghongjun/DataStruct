package com.datastruct.line;

import java.util.Scanner;

/*
栈：
    栈结构是从数据的运算来分类的，也就是说栈结构具有特殊的运算规则。而从数据的逻辑结构来看，栈结构其实就是一种线性结构。如果从数据的
存储结构来进一步划分，栈结构包括两类：
                                顺序结构：即使用一组地址连续的内存单元依次保存栈中的数据。在程序中，可以定义一个指定大小的结构
                  数组作为栈，序号为0的元素就是栈底，再定义一个变量top保存栈顶的序号即可。
                                链式结构：即使用链表形式保存栈中各元素的值。链表首部（head引用所指向元素）为栈顶，链表尾部（指向
                  地址为null）为栈底。
                  
    在栈结构中只能在一端进行操作，该操作端称为栈顶，另一端称为栈底，也就是说，保存和取出数据只能从栈结构的一端进行。从数据的运算角度来
分析，栈结构是按照“后进先出”的原则处理结点数据的。

    在栈结构中，只有栈顶元素是可以访问的。这样，栈结构的数据运算非常简单。一般栈结构的基本操作有两个：
    
                      入栈（push）：将数据保存到栈顶的操作。进行入栈操作前，先修改栈顶引用，使其向上移一个元素位置，然后将数据保存
                   到栈顶引用所指的位置。
                      出栈（pop）:将栈顶的数据弹出的操作。通过修改栈顶引用，使其指向栈中的下一个元素。
                      
*/

//ADT
class DATA{
    String mName;
    int mAge;
}

//栈结构
class StackType{
    //栈的长度
    static final int MAXLEN = 50;
    //数据元素
    DATA[] mData = new DATA[MAXLEN + 1];
    //栈顶
    int mTop;
    
    /**
     * 初始化栈结构，首先使用new关键字申请内存，申请成功后设置栈定为0，然后返回申请内存的首地址。如果申请内存失败，将返回null。
     */
    StackType initST(){
        //1.按符号常量SIZE指定的大小申请一片内存空间，用来保存栈中的数据
        StackType p;
        if ((p = new StackType()) != null) {
            //2.设置栈顶引用的值为0，表示是一个空栈
            p.mTop = 0;
            //返回指向栈的引用
            return p;
        }
        return null;
    }
    
    /**
     * 判断空栈就是判断一个栈结构是否为空。如果是空栈，则表示该栈结构中没有数据。此时可以进行入栈操作，但不可以进行出栈操作。
     * @param s:指向操作栈的引用
     * @return
     */
    boolean isSTEmpty(StackType s){
        //栈顶引用top是否为0，判断栈是否为空
        return s.mTop == 0;
    }
    
    /**
     * 判断栈满就是判断栈结构是否为满。如果是满栈，则表示该栈结构没有多余的空间来保存额外数据。此时不可以进行入栈操作，但是可以进行
     * 出栈操作
     * @param s:指向操作栈的引用
     * @return
     */
    boolean isSTFull(StackType s){
        //栈顶引用top是否等于MAXLEN,从而判断是否已满
        return s.mTop == MAXLEN;
    }
    
    /**
     * 清空栈就是栈中的所有数据清除。
     * @param s:指向操作栈的引用
     * @return
     */
    void clearST(StackType s){
        //栈顶引用top设置为0，表示执行清空栈操作
        s.mTop = 0;
    }
    
    /**
     * 释放空间就是释放栈结构所占用的内存单元
     * @param s:指向操作栈的引用
     * @return
     */
    void freeST(StackType s){
        if (s != null) {
            //直接赋值null操作释放所分配的内存。一般在不需要使用栈结构的时候使用，特别是程序结束时。
            s = null;
        }
    }

    /**
     * 入栈是栈的基本操作，主要操作是将数据元素保存到栈结构。程序中首先判断栈是否溢出，如果溢出则不进行入栈操作，否则
     * 修改栈顶引用的值，再将元素入栈
     * @param s:操作的栈的引用
     * @param data：需要入栈的数据元素
     * @return
     */
    int pushST(StackType s, DATA data){
        //1.首先判断栈顶top,如果top大于等于SIZE，则表示溢出，进行出错处理；否则执行以下操作
        if ((s.mTop + 1) > MAXLEN) {
            System.out.println("栈溢出！");
            return 0;
        }
        //2.设置top = top + 1(栈顶引用加1，指向入栈地址)
        //3.将入栈元素保存到top指向的位置
        s.mData[++s.mTop] = data;
        return 1;
    }
    
    /**
     * 出栈是栈的基本操作。主要操作与入栈相反。其实从栈顶弹出一个数据元素。
     */
    DATA popST(StackType s){
        //1.判断栈顶top，如果top等于0，则表示为空栈，进行出错处理；否则，执行下面操作
        if (s.mTop == 0) {
            System.out.println("栈为空!");
            return null;
        }
        //2.将栈顶引用top所指位置的元素返回
        //3.设置top= top -1,也就是使栈顶引用减1，指向栈的下一个元素，原来栈顶元素被弹出
        return s.mData[s.mTop--];
    }
    
    /**
     * 读取结点数据就是读取栈中结点的数据。由于栈只能在一端进行操作，因此这里读操作其实就是读的栈顶的数据
     * 需要注意的是，读结点数据的操作和出栈操作不同，读结点数据的操作仅是显示栈顶结点数据的内容，而出栈操
     * 作则将栈顶数据弹出，该数据不再存在。
     */
    DATA peekST(StackType s){
        if (s.mTop == 0) {
            System.out.println("栈为空！");
            return null;
        }
        return s.mData[s.mTop];
    }
}



public class Stack {

    public static void main(String[] args) {

        StackType st = new StackType();
        DATA data1= new DATA();
        
        //初始化栈
        StackType stack = st.initST();
        Scanner input = new Scanner(System.in);
        System.out.println("入栈操作：");
        System.out.println("输入姓名 年龄进行入栈操作：");
        
        do{
            DATA data = new DATA();
            data.mName = input.next();
            if (data.mName.compareTo("0") == 0) {
                //若输入0，则退出
                break;
            } else {
                data.mAge = input.nextInt();
                st.pushST(stack, data);
            }
        }while(true);
        String temp = "1";
        System.out.println("出栈操作：按任意非0键进行出栈操作：");
        temp = input.next();
        while (!temp.equals("0")) {
            data1 = st.popST(stack);
            System.out.printf("出栈的数据是（%s,%d）", data1.mName, data1.mAge);
            temp = input.next();
        }
        System.out.println("测试结束！");
        //释放栈所占用的空间
        st.freeST(stack);
        
    }

}
