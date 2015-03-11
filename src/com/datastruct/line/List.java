package com.datastruct.line;

import java.util.Scanner;

/*
链表：
    
    链表中每个结点都应该包括如下两个部分：
        数据部分：保存的是该结点的实际数据；
        地址部分：保存的是下以额结点的地址；

    链表结构就是由许多这种结点构成。在进行链表操作时，首先需要定义一个“头引用”变量（一般以head表示），该引用变量指向链表结构的第一个结点，第一个结点的地址部分
又指向第二个结点....,直到最后一个结点。最后一个结点不再指向其他结点，成为“表尾”，一般在表尾的地址部分放一个地址"null",链表到此结束。

    链表结构中，逻辑上相邻的结点在内存中并不一定相邻，逻辑相邻关系通过地址部分的引用变量来实现。
    
    优点
        链表结构带来的最大好处便是结点之间不要求连续存放，因此在保存大量数据的时候，不需要分配一块连续的存储空间。用户可以用new函数动态分配结点的存储空间，当删除某
    个结点时，给该结点赋值“null”，释放其占用的内存空间。

    缺点
        链表结构也是有缺点，那就是浪费存储空间。因此，对于每个结点数据，都要额外保存以额引用变量。
        
        对链表的访问只能从表头逐个查找，即通过head头引用找到第一个结点，再从第一个结点找到第二个结点,....这样逐个比较一直到找到需要的结点为止，而不能像顺序表那样
    随机访问。

*/

//ADT
class DATA {
    String mKey;
    String mName;
    int mAge;
}

// 链表结构
class CLType {
    // 保存结点的数据
    DATA mNodeData = new DATA();
    // 用来指向下一个结点
    CLType mNextNode;

    /**
     * 追加结点就是在链表末尾增加一个结点
     * 
     * @param head
     *            :链接头引用
     * @param nodeData
     *            :结点保存的数据
     * @return
     */
    CLType addCLEnd(CLType head, DATA nodeData) {
        // 1.分配内存空间，保存新增的结点
        CLType node, htemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！");
            // 分配内存失败
            return null;
        } else {
            // 保存数据
            node.mNodeData = nodeData;
            // 4.将新增结点的地址部分设置为空地址null,即新增结点成为表尾
            node.mNextNode = null;
            if (head == null) {
                head = node;
                return head;
            }
            // 2.从头引用head开始逐个检查，直到找到最后一个结点（表尾）
            htemp = head;
            while (htemp.mNextNode != null) {
                htemp = htemp.mNextNode;
            }
            // 3.将表尾结点的地址设置为新增结点的地址
            htemp.mNextNode = node;
            return head;
        }
    }

    /**
     * 插入头结点就是在链表首部添加结点
     * 
     * @param head
     *            :链表头引用
     * @param nodeData
     *            :结点保存的数据
     * @return
     */
    CLType addCLFirst(CLType head, DATA nodeData) {
        // 1.分配内存空间，保存新增的结点
        CLType node;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！");
            // 分配内存失败
            return null;
        } else {
            // 保存数据
            node.mNodeData = nodeData;
            // 2.使新增结点指向头引用head所指向的结点
            node.mNextNode = head;
            // 3.使头引用head指向新增结点
            head = node;
        }
        return null;
    }

    /**
     * 查找结点就是在链表中查找需要的元素，对于链表来说，一般可通过关键字进行查询，首先从链表头引用开始，对结点进行逐个比较，直到查找到
     * 
     * @param head
     *            :链表头引用
     * @param key
     *            :用来在链表中进行查找结点的关键字
     * @return
     */
    CLType findCLNode(CLType head, String key) {
        CLType htemp;
        // 保存链表头引用
        htemp = head;
        // 若结点有效，则进行查找
        while (htemp != null) {
            // 若结点关键字与传入关键字相同
            if (htemp.mNodeData.mKey.compareTo(key) == 0) {
                // 返回该结点引用
                return htemp;
            }
            htemp = htemp.mNextNode;
        }
        return null;
    }

    /**
     * 插入结点就是在链表中间部分的指定位置增加一个结点。首先使用new关键字申请保存结点数据的内存空间，然后调用方法查找指定关键字，接着执行插入操作。
     * 
     * @param head
     *            :链表头引用
     * @param findKey
     *            :用来在链表中进行查找的结点关键字，找到该结点后将在该结点后面添加结点数据
     * @param nodeData
     *            :新增结点的数据
     * @return
     */

    CLType insertCLNode(CLType head, String findKey, DATA nodeData) {
        // 1.分配内存空间，保存新增的结点
        CLType node, nodetemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！");
            // 分配内存失败
            return null;
        }
        // 保存结点中的数据
        node.mNodeData = nodeData;
        // 2.找到要插入的逻辑位置，也就是位于哪两个结点之间
        nodetemp = findCLNode(head, findKey);
        if (nodetemp != null) {
            // 3.修改插入位置结点的引用，使其指向新增结点，而使新增结点指向原插入位置所指向的结点
            node.mNextNode = nodetemp.mNextNode;
            nodetemp.mNextNode = node;
        } else {
            System.out.println("未找到正确的插入位置！");
        }
        return head;
    }

    /**
     * 删除结点就是将链表中的某个结点数据删除。程序中，通过一个循环，按关键字在整个链表中查找要删除的结点。如果找到被删除结点，则设置
     * 上一结点（node引用所指结点）指向当前结点（h引用所指结点）的下一结点，即可完成链表中结点的逻辑删除。但是，此时被删除结点仍然保
     * 存在内存中，接着执行赋值null操作，用来释放被删除结点所占用的内存空间
     * 
     * @param head
     *            :链表头引用
     * @param key
     *            :表示一个关键字
     * @return
     */
    int deleteCLNode(CLType head, String key) {
        CLType node, htemp;// node 保存删除结点的前一结点
        htemp = head;
        node = head;
        // 1.查找需要删除的结点
        while (htemp != null) {
            // 找到关键字
            if (htemp.mNodeData.mKey.compareTo(key) == 0) {
                // 2.使前一结点指向当前结点的下一结点
                node.mNextNode = htemp.mNextNode;
                // 3.删除结点
                htemp = null;
                return 1;
            } else {
                // 指向当前结点
                node = htemp;
                // 指向下一结点
                htemp = htemp.mNextNode;
            }
        }
        // 未删除
        return 0;
    }

    /**
     * 计算链表长度也就是统计链表结构中结点数量。在顺序表中比较方便，但是在这里，由于链表结构在物理并不是连续存储的。因此，计算链表长度
     * 稍复杂些，需要遍历整个链表来对结点数量进行累加得到
     * 
     * @param head
     *            :链表的头引用
     * @return
     */
    int clLength(CLType head) {
        CLType htemp;
        int len = 0;
        htemp = head;
        // 遍历整个链表
        while (htemp != null) {
            // 累加结点数量
            len++;
            // 处理下一个结点
            htemp = htemp.mNextNode;
        }
        // 返回结点数量
        return len;
    }

    /**
     * 显示所有结点数据并不是一个数据结构基本的运算，因为其可以简单地逐个引用结点来实现。
     * 
     * @param head
     */
    void allCLNode(CLType head) {
        CLType htemp;
        DATA nodeData;
        htemp = head;
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：", clLength(head));
        // 循环处理链表每个结点
        while (htemp != null) {
            // 获取结点数据
            nodeData = htemp.mNodeData;
            System.out.printf("结点(%s, %s, %d), ", nodeData.mKey, nodeData.mName, nodeData.mAge);
            // 处理下一结点
            htemp = htemp.mNextNode;
        }
    }
}

public class List {

    public static void main(String[] args) {

        CLType node, head = null;
        CLType cl = new CLType();
        String key, findKey;
        Scanner input = new Scanner(System.in);

        System.out.println("链表测试。先输入链表中的数据，格式为： 关键字 姓名 年龄");

        do {
            DATA nodeData = new DATA();
            nodeData.mKey = input.next();
            // 若输入0，则退出
            if (nodeData.mKey.equals("0")) {
                break;
            } else {
                nodeData.mName = input.next();
                nodeData.mAge = input.nextInt();
                // 在链表尾部添加结点
                head = cl.addCLEnd(head, nodeData);
            }
        } while (true);

        // 显示所有结点
        cl.allCLNode(head);

        System.out.println("演示插入结点， 输入插入位置的关键字：");
        // 输入插入位置关键字
        findKey = input.next();
        System.out.println("输入插入结点的数据（关键字 姓名 年龄）：");
        DATA nodeData = new DATA();
        nodeData.mKey = input.next();
        nodeData.mName = input.next();
        nodeData.mAge = input.nextInt();
        // 插入结点
        head = cl.insertCLNode(head, findKey, nodeData);
        // 显示所有结点
        cl.allCLNode(head);

        System.out.println("演示删除结点，输入要删除的关键字：");
        // 输入删除结点的关键字
        key = input.next();
        // 删除结点
        cl.deleteCLNode(head, key);
        // 显示所有结点
        cl.allCLNode(head);

        System.out.println("演示在链表中查找，输入查找关键字：");
        key = input.next();
        // 查找结点
        node = cl.findCLNode(head, key);
        if (node != null) {
            nodeData = node.mNodeData;
            System.out.printf("结点(%s, %s, %d), ", nodeData.mKey, nodeData.mName, nodeData.mAge);
        } else {
            System.out.printf("在链表中未找到关键字为%s的结点！", key);
        }

    }

}
