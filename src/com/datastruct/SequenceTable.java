package com.datastruct;

import java.util.Scanner;

/*
线性表：

    从逻辑上来看，线性表就是有n(n>=0)个数据元素a1,a2,...,an组成的有限序列；
    需要说明几点：
        数据元素的个数为n,也称为表的长度，当n=0的时候称为空表；
        如果一个线性表非空，也就是n>0,则可以简单地记作（a1,a2,...,an);
        数据元素ai(1<=i<=n)表示了各个元素；

    对于一个非空的线性表，其逻辑结构特征如下：
        有且仅有一个开始结点a1,没有直接前趋结点，有且仅有一个直接后继结点a2;
        有且仅有一个终结结点an,没有直接后继结点，有且仅有一个直接前趋结点an-1;
        其余的内部结点ai(2<=i<=n-1)都有且仅有一个直接前趋结点ai-1和一个直接后继结点ai+1;
        对于同一线性表，各数据元素ai必须具有相同的数据类型，即同一线性表中各数据元素具有相同的类型，每个数据元素的长度相同。

    缺点：
        在插入或者删除结点的时候，往往需要移动大量的数据；
        如果表比较大，有时比较难分配足够的连续存储空间，往往导致内存分配失败，而无法存储；

*/



/**
 * 顺序表结构实例
 */

// ADT
class DATA {
    String mKey;
    String mName;
    int mAge;
}

// 顺序表结构
class SLType {
    static final int MAXLEN = 100;
    DATA[] mListData = new DATA[MAXLEN + 1];
    int mListLen;

    /**
     * 初始化表也就是构造一个空的线性表
     */
    void initSL(SLType sl) {
        // 初始化为空表
        sl.mListLen = 0;
    }

    /*
     * 计算表长也就是计算线性表中结点的个数
     */
    int slLength(SLType sl) {
        return sl.mListLen;
    }

    /**
     * 插入结点就是在线性表的第i个位置上插入一个新的结点，使得其后的结点编号依次加1.这时，插入一个新结点之后，线性表的长度将变成n+1
     */
    int insertSL(SLType sl, int n, DATA data) {
        int i;
        // 检查順序表结点数量是否已超过最大数量
        if (sl.mListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入结点！");
            return 0;
        }
        // 检查插入结点序号是否正确
        if (n < 1 || n > sl.mListLen - 1) {
            System.out.println("插入元素序号错误，不能插入元素!");
            return 0;
        }
        // 将顺序表中的数据向后移动
        for (i = sl.mListLen; i >= n; i--) {
            sl.mListData[i + 1] = sl.mListData[i];
        }
        // 插入结点
        sl.mListData[n] = data;
        // 顺序表结点数量增加1
        sl.mListLen++;
        // 成功插入，返回1
        return 1;
    }

    // 增加元素到顺序表尾部
    int addSL(SLType sl, DATA data) {
        // 检查顺序表是否已满
        if (sl.mListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能再添加结点了！");
            return 0;
        }
        sl.mListData[++sl.mListLen] = data;
        return 1;
    }

    // 删除顺序表中的数据元素
    int deleteSL(SLType sl, int n) {
        int i;

        // 检查节电序号是否正确
        if (n < 1 || n > sl.mListLen + 1) {
            System.out.println("删除结点序号错误，不能删除结点！");
            return 0;
        }
        // 将顺序表中的数据向前移动
        for (i = n; i < sl.mListLen; i++) {
            sl.mListData[i] = sl.mListData[i + 1];
        }
        // 顺序表元素数量减1
        sl.mListLen--;
        return 1;
    }

    // 根据序号返回数据元素
    DATA findSLByNum(SLType sl, int n) {
        // 检查元素序号是否正确
        if (n < 1 || n > sl.mListLen + 1) {
            System.out.println("结点序号错误，不能返回结点！");
            return null;
        }
        return sl.mListData[n];
    }

    // 根据关键字查询结点
    int findSLByCont(SLType sl, String key) {
        int i;
        for (i = 0; i <= sl.mListLen; i++) {
            // 如果找到所需结点
            if (sl.mListData[i].mKey.compareTo(key) == 0) {
                // 返回结点序号
                return i;
            }
        }
        // 搜索整个表后，没有找到，则返回0
        return 0;
    }

    // 显示顺序表中所有的结点
    int allSL(SLType sl) {
        int i;
        for (i = 1; i <= sl.mListLen; i++) {
            System.out.printf("(%s,%s,%d)\n", sl.mListData[i].mKey, sl.mListData[i].mName, sl.mListData[i].mAge);
        }
        return 0;
    }
}

public class SequenceTable {

    public static void main(String[] args) {
        int i;

        // 定义顺序表变量
        SLType sl = new SLType();
        // 定义结点保存引用变量
        DATA pdata;
        // 保存关键字
        String key;

        System.out.println("初始化顺序表完成！");

        Scanner input = new Scanner(System.in);

        // 循环添加结点数据
        do {
            System.out.println("输入添加的结点（学号，姓名，年龄）： ");
            DATA data = new DATA();
            data.mKey = input.next();
            data.mName = input.next();
            data.mAge = input.nextInt();

            // 若年龄不为0
            if (data.mAge != 0) {

                // 若添加结点失败
                if (sl.addSL(sl, data) == 0) {
                    // 退出死循环
                    break;
                }

            } else {
                break;
            }
        } while (true);

        System.out.println("要取出结点的序号： ");
        // 输入结点点序号
        i = input.nextInt();
        // 按序号查找结点
        pdata = sl.findSLByNum(sl, i);
        // 若返回的结点引用不为null
        if (pdata != null) {
            System.out.printf("第%d个结点为：（%s,%s,%d）\n", i, pdata.mKey, pdata.mName, pdata.mAge);
        }

        System.out.println("要查找结点关键字： ");
        // 输入关键字
        key = input.next();
        // 按关键字查找，返回结点序号
        i = sl.findSLByCont(sl, key);
        // 按序号查询，返回结点引用
        pdata = sl.findSLByNum(sl, i);
        if (pdata != null) {
            System.out.printf("第%d个结点为：（%s,%s,%d）\n", i, pdata.mKey, pdata.mName, pdata.mAge);
        }

    }
}
