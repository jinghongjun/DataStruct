package com.datastruct.noline;

import java.util.Scanner;

/**
 * 树：
 *    树结构是一种描述非线性层次关系的数据结构。树是n个数据结点的集合，在该集合中包含一个根结点，根结点之下分布着一些互不交叉的子集合
 * 这些子集合也就是根结点的子树。
 * 
 *    树结构的特征
 *      在一个树结构中，有且仅有一个结点没有直接前驱，这个结点就是树的根结点
 *      除根结点外，其余每个结点有且仅有一个直接前驱
 *      每个结点可以有任意多个直接后继
 *      
 *    父结点和子结点：每个结点的子树的根称为该结点的子结点，相应地，该结点被称为子结点的父结点。
 *    兄弟结点：具有同一父结点的结点成为兄弟结点
 *    结点的度：一个结点所包含子树的数量
 *    树的度：是指该树所有结点中最大的度
 *    叶结点：树中度为零的结点称为叶结点或终端结点
 *    分支结点：树中度不为零的结点称为分支结点或非终端结点
 *    结点的层数：结点的层数从树根开始计算，根结点为第1层，依次向下为2，3....,n层。
 *    树的深度：树中结点的最大层数称为树的深度
 *    有序树：若树中各结点的子树（兄弟结点）是按一定次序从左到右排列的
 *    无序树：若树中各结点的子树（兄弟结点）是未按一定次序排列的
 *    森林：n（n > 0）颗互不相交的树的集合
 *    
 *    树的表示
 *      一般来说，常采用层次括号法。层次括号法的基本规则如下：
 *          根结点放入一对圆括号中
 *          根结点的子树由左至右的顺序放入括号中
 *          对子树做上述相同的处理
 *          这样，同层子树与它的根结点用圆括号括起来，同层子树之间用逗号隔开，最后用闭括号括起来。
 *          
 *          
 *  二叉树
 *       在树结构中，二叉树是最简单的一种形式，描述性对简单，处理也相对简单，而且更为重要的是任意的树都可以转换成对应的二叉树。
 *       二叉树是树结构的一种特殊形式，其中n个结点的集合，每个结点最多只能有两个子结点。二叉树的子树仍然是二叉树。二叉树的一
 *个结点上对应的两个子树分别称为左子树和右子树，由于子树有左右之分，因此二叉树是有序树。为了便于研究，二叉树还可以进一步细分为
 *两种特殊的类型，满二叉数和完全二叉数
 *       
 *       满二叉树：除最下一层的叶结点外，每层的结点都有两个子结点
 *       完全二叉树：在二叉树中除二叉树最后一层外，其他个层的结点都达到最大个数，且最后一层叶结点按照从左向右的顺序连续存在，只
 *缺最后一层右侧若干结点
 *
 *       完全二叉树的性质
 *          对于完全二叉树，如果树中包含n个结点，假设这些结点按照顺序方式存储，那么，对于任意一个结点m来说，具有如下性质：
 *              如果m!= 1,则结点m的父结点的编号为m/2;
 *              如果2*m<=n,则结点m的左子树根结点的编号为2*m；若2*m>n,则无左子树，进一步也就没有右子树。
 *              如果2*m +1<=n,则结点m的右子树根结点编号为2*m+1;若2*m+1>n,则无右子树。另外，对于该完全二叉数来说，其深度为log2n+1;
 *              
 *       按照数据的存储方式，树结构可以分为顺序存储和链式存储。
 *       
 *       顺序存储
 *          顺序存储方式是最基本的数据存储方式，与线性表类似，树结构的顺序存储一般也是采用一维数组来表示。这里的关键是定义合适的次序来
 *存放树中的各个层次的数据。如果采用顺序存储方式，我们可以将其按层来存储。即先存储根结点，然后从左至右依次存储下一层结点的数据，...直到
 *所有的结点数据完全存储。
 *
 *       顺序存储二叉树
 *       //最大结点数
 *       static final int MAXLEN = 100;
 *       //保存二叉树数组
 *       char[] seqBinTree = new char[MAXLEN];
 *       
 *       顺序存储方式一般只适用于完全二叉树的情况，对于更为一般的情况，一般建议采用链式存储方法
 *       
 *       链式存储
 *          与线性结构的链式存储类似，二叉树的链式存储包含结点元素以及分别指向左子树和右子树的引用。
 *          
 *       class ChainTreeType{
 *          //元素数据
 *          char NodeData;
 *          //左子树结点引用
 *          ChainTree LSonNode;
 *          //右子树结点引用
 *          ChainTree RSonNode;
 *          //父结点引用
 *          Chain ParentNode;
 *       }
 *       
 *       //定义二叉树根结点引用
 *       ChainTreeType root = null;
 */

//
class CBTType {
    //最大长度
    static final int MAXLEN = 20;
    //ADT
    String mData;
    //左子树结点引用
    CBTType mLeft;
    //右子树结点引用
    CBTType mRight;
    
    /**
     * 初始化二叉树
     * 在使用顺序表之前，首先要初始化二叉树。程序中只需将一个结点设置为二叉树的根结点
     * @return
     */
    CBTType initTree(Scanner input){
        CBTType node;
        //申请内存
        if ((node = new CBTType()) != null){
            System.out.println("请先输入一个根结点数据");
            node.mData = input.next();
            node.mLeft = null;
            node.mRight = null;
            if (node != null) {
                return node;
            } else {
                return null;
            }
        }
        return null;
    }
    
    /**
     * 添加结点就是在二叉树中添加结点数据，添加结点时除了要输入结点数据外，还需要指定其父结点，以及添加的结点是作为左子树还是右子树
     * 程序中首先申请内存，然后由用户输入二叉树结点数据，并设置左右子树为空，接着指定其父结点，最后设置其作为左子树还是右子树。
     * @param treeNode:二叉树的根结点（传入根结点便于代码中进行查找）
     */
    void addTreeNode(CBTType treeNode,Scanner input){
        CBTType pnode, parent;
        String data;
        int menusel;
        
        //分配内存
        if ((pnode = new CBTType()) != null) {
            System.out.println("输入二叉树结点数据：");
            pnode.mData = input.next();
            //设置左右子树为空
            pnode.mLeft = null;
            pnode.mRight = null;
            
            System.out.println("输入该结点的父结点数据：");
            
            data = input.next();
            //查找指定数据的结点
            parent = findTreeNode(treeNode, data);
            //如果未找到
            if (parent == null) {
                System.out.println("未找到该父结点！");
                //释放创建的结点内存
                pnode = null;
                return;
            }
            System.out.println("1.添加该结点到左子树，2.添加该结点到右子树。");
            do{
                //输入选择项
                menusel = input.nextInt();
                if (menusel == 1 || menusel == 2) {
                    if (parent == null) {
                        System.out.println("不存在父结点，请先设置父结点！");
                    } else {
                        switch(menusel){
                        case 1:
                            //添加到左结点
                            if (parent.mLeft != null) {
                                System.out.println("左子树结点不为空！");
                            } else {
                                parent.mLeft = pnode;
                            }
                            break;
                        case 2:
                            //添加到右结点
                            if (parent.mRight != null) {
                                System.out.println("右子树结点不为空！");
                            } else {
                                parent.mRight = pnode;
                            }
                            break;
                         default:
                             System.out.println("无效参数！");
                             break;
                        }
                    }
                }
            }while(menusel != 1 && menusel != 2);
        }
    }

    
    /**
     * 获取左子树就是返回当前结点的左子树结点的值
     * 程序将返回该结点的左子树的引用
     * @param treeNode:二叉树的一个结点
     * @return
     */
    CBTType leftTreeNode(CBTType treeNode){
        if (treeNode != null) {
            return treeNode.mLeft;
        }
        return null;
    }
    
    /**
     * 获取右子树就是返回当前结点的右子树结点的值
     * 程序将返回该结点的右子树的引用
     * @param treeNode:二叉树的一个结点
     * @return
     */
    CBTType rightTreeNode(CBTType treeNode){
        if (treeNode != null) {
            return treeNode.mRight;
        }
        return null;
    }
    
    /**
     * 计算二叉树深度就是计算二叉树中结点的最大层数。程序中首先判断根结点是否为空，然后分别按照递归调用来计算左子树和右子树的深度，
     * 从而完成整个二叉树深度的计算
     * @param treeNode:待计算的二叉树的根结点
     * @return
     */
    int treeDepth(CBTType treeNode){
        int depleft, depright;
        if (treeNode == null){
            //对于空树，深度为0
            return 0;
        } else {
            //左子树深度（递归调用）
            depleft = treeDepth(treeNode.mLeft);
            //右子树深度（递归调用）
            depright = treeDepth(treeNode.mRight);
            if (depleft > depright) {
                return depleft + 1;
            } else {
                return depright + 1;
            }
        }
    }
    
    /**
     * 清空二叉树就是将二叉树变成一个空树。这里需要使用递归算法来实现。程序中按照递归调用来清空左右子树，并且使用赋值null操作来释放
     * 当前结点所占内存，从而完成清空操作。
     * @param treeNode:待清空的二叉树的根结点
     */
    void clearTree(CBTType treeNode){
        if (treeNode != null) {
            //清空左子树
            clearTree(treeNode.mLeft);
            //清空右子树
            clearTree(treeNode.mRight);
            //释放当前结点所占内存
            treeNode = null;
        }
    }
    
    /**
     * 显示结点就是显示当前结点的数据内容
     * @param p:待显示的结点
     */
    void treeNodeData(CBTType p){
        System.out.printf("%s", p.mData);
    }
    
  /**
    遍历二叉树：逐个查找二叉树中所有的结点。
    
    按层遍历
        二叉树代码的是一种层次结构，因此，我们首先想到的便是按层来遍历整个二叉树。对于二叉树的按层遍历，一般不能使用递归算法来编码，而是
        使用一个循环队列来进行处理。首先将第1层（根结点）进入队列，再将第1根结点的左右子树（第2层）进入队列,就这样循环处理，可以逐层遍历。
    
    使用递归遍历
        先序遍历：即先访问根结点，再按先序遍历左子树，最后按先序遍历右子树。先序遍历一般也称为先根次序遍历，简称DLR遍历
        中序遍历：即先按中序遍历左子树，再访问根结点，最后按中序遍历右子树。中序遍历一般也称为中根次序遍历，简称LDR遍历
        后序遍历：即先按后序遍历左子树，再按后序遍历右子树，最后访问根结点。后序遍历一般也称为后根次序遍历，简称LRD遍历
        
        先序遍历，中序遍历和后序遍历的最大好处便是可以方便地利用递归的思想来实现遍历算法
  */
    
    /**
     * 按层遍历是最直观的遍历算法。首先处理第1层（根结点），再处理第1层根结点的左右子树，即是第2层，....就这样循环处理，就可以逐层遍历。
     * 程序在整个处理过程中，首先从根结点开始，将每层的结点逐步进入队列，这样就可得到按层遍历的效果
     * @param treeNode:需要遍历的二叉树根结点
     */
    void levelTree(CBTType treeNode){
        CBTType p;
        //定义一个顺序栈
        CBTType[] q = new CBTType[MAXLEN];
        int head = 0,tail = 0;
        
        //如果队首引用不为空
        if (treeNode != null) {
            //计算循环队列队尾序号
            tail = (tail + 1) % MAXLEN;
            //将二叉树根引用进队
            q[tail] = treeNode;
        }
        
        //队列不为空，进行循环
        while(head != tail){
            //计算循环队列的队首序号
            head = (head + 1) % MAXLEN;
            //获取队首元素
            p = q[head];
            //处理队首元素
            treeNodeData(p);
            //如果结点存在左子树
            if (p.mLeft != null) {
                //计算循环队列的队尾序号
                tail = (tail + 1) % MAXLEN;
                //将左子树引用进队
                q[tail] = p.mLeft;
            }
            //如果结点存在右子树
            if (p.mRight != null){
                //计算循环队列的队尾序号
                tail = (tail + 1) % MAXLEN;
                //将右子树引用进队
                q[tail] = p.mRight;
            }
                    
        }
    }
    
    /**
     * 先序遍历就是先按中序遍历左子树，再访问根结点，最后按中序遍历右子树。程序中可以按照递归的思路来遍历整个二叉树
     * @param treeNode:需要遍历的二叉树根结点
     */
    void treeDLR(CBTType treeNode){
        if (treeNode != null) {
            //显示结点的数据
            treeNodeData(treeNode);
            treeDLR(treeNode.mLeft);
            treeDLR(treeNode.mRight);
        }
    }
    
    /**
     * 中序遍历就是先访问根结点，再按先序遍历左子树，最后按先序遍历右子树。程序中可以按照递归的思路来遍历整个二叉树
     * @param treeNode:需要遍历的二叉树根结点
     */
    void treeLDR(CBTType treeNode){
        if (treeNode != null) {
            //中序遍历左子树
            treeLDR(treeNode.mLeft);
            //显示结点数据
            treeNodeData(treeNode);
            //中序遍历右子树
            treeLDR(treeNode.mRight);
        }
    }
    
    /**
     * 后序遍历就是先按后序遍历左子树，再按后序遍历右子树，最后访问根结点。程序中可以按照递归的思路来遍历整个二叉树
     * @param treeNode:需要遍历的二叉树根结点
     */
    void treeLRD(CBTType treeNode){
        if (treeNode != null) {
            //后序遍历左子树
            treeLRD(treeNode.mLeft);
            //后序遍历右子树
            treeLRD(treeNode.mRight);
            //显示结点数据
            treeNodeData(treeNode);
        }
    }
    
    /**
     * 查找结点就是遍历二叉树中的每个结点中，逐个比较数据，当找到目标数据时将返回该数据所在结点的引用。程序中首先判断根结点是否为空
     * ，然后分别向左右子树递归查找。如果当前结点的数据与查找数据相等，则返回当前结点的引用
     * @param treeNode:待查找的二叉树的根结点
     * @param data:待查找的结点数据
     * @return
     */
    CBTType findTreeNode(CBTType treeNode, String data){
        CBTType ptr;
        if (treeNode == null) {
            return null;
        } else {
            if (treeNode.mData.equals(data)) {
                return treeNode;
            } else {
                //分别向左右子树递归查找
                if ((ptr = findTreeNode(treeNode.mLeft, data)) != null) {
                    return ptr;
                } else if ((ptr = findTreeNode(treeNode.mRight, data)) != null) {
                    return ptr;
                } else {
                    return null;
                }
            }
        }
    }
}



public class Tree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //root为指向二叉树根结点的引用
        CBTType root = null;
        
        int menusel;
        CBTType t = new CBTType();
        //设置根元素
        root = t.initTree(input);
        
        //添加结点
        do {
            System.out.println("请选择菜单添加二叉树的结点");
            //显示菜单
            System.out.println("0.退出");
            System.out.println("1.添加二叉树的结点");
            menusel = input.nextInt();
            switch (menusel) {
            case 1:
                //添加结点
                t.addTreeNode(root, input);
                break;
            case 0:
                break;
            default:
                break;
            }
        } while(menusel != 0);
        
        //遍历
        do {
            System.out.println("请选择菜单遍历二叉树，输入0表示退出：");
            //显示菜单
            System.out.println("1.先序遍历DLR");
            System.out.println("2.中序遍历LDR");
            System.out.println("3.后序遍历LRD");
            System.out.println("4.按层遍历");
            menusel = input.nextInt();
            switch (menusel){
            case 0:
                break;
            case 1:
                //先序遍历
                System.out.println("先序遍历DLR的结果：");
                t.treeDLR(root);
                System.out.println("");
                break;
            case 2:
                //中序遍历
                System.out.println("中序遍历LDR的结果：");
                t.treeLDR(root);
                System.out.println("");
                break;
            case 3:
                //后序遍历
                System.out.println("后序遍历LRD的结果：");
                t.treeLRD(root);
                System.out.println("");
                break;
            case 4:
                //按层遍历
                System.out.println("按层遍历的结果：");
                t.levelTree(root);
                System.out.println("");
                break;
            }
        } while(menusel != 0);
        
        //深度
        System.out.printf("二叉树深度为：%d", t.treeDepth(root));
        //清空二叉树
        t.clearTree(root);
        root = null;
    }

}
