package com.datastruct.find;

import java.util.Scanner;

/**
 * 查找是指从一批记录中找出满足指定条件的某一记录的过程。
 * 在实际应用中，针对不同的情况往往可以选择不同的查找算法。对于无顺序的数据，只有逐个比较数据，才能找到需要的内容。这称为顺序查找。
 *对于有顺序的数据，也可以采用顺序查找法逐个比较，但还可以采取更快速的方法来找到所需的数据。另外，对于一些特殊的数据结构，例如链表
 *树结构和图结构等，其都有对应的查找算法
 *
 */

public class Find {

    /**
     * 顺序查找
     * 顺序查找其执行操作是从数据序列中的第1个元素开始，从头到尾依此逐个查找，直到找到所要的数据或搜索完整个数据序列。顺序查找主要
     * 针对少量、无规则的数据。对于包含n个数据的数据序列，使用顺序查找方法查找数据，最理想的情况是目标数据位于数组的第一个，这样比
     * 较1次就找到目标数据。而最差的情况是需比较完所有的n个数据才找到目标数据或确定没有该数据。平均来说，比较次数为n/2次，效率是比
     * 较差的
     * 查找操作
     *  从头开始，逐个比较数组中的元素，找到相应数据后，则将该元素的序号保存到变量f中，并通过break语句跳出循环
     * @param a:数组
     * @param n:数组的长度
     * @param x:待查找的数据
     * @return
     */
    public static int findSequence(int[] a, int n, int x){
        int i, f = -1;
        for (i = 0; i < n; i++) {
            //查找到
            if (x == a[i]) {
                f = i;
                break;
            }
        }
        return f;
    }
    
    /**
     * 折半查找
     * 折半查找又称为二分查找，其要求数据序列呈线性结构，也就是经过排序的。对于没有经过排序的，通过排序算法来进行排序，然后执行折半
     *查找操作
     * 折半查找操作步骤
     *   首先需要设三个变量lownum、midnum、highnum,分别保存数组元素的开始、中间和末尾的序号，假定有10个元素，开始时令lownum=0
     * highnum = 9; midnum = (lownum + highnum)/2=4，接着进行一下判断:
     *   1.如果序号为midnum的数组元素的值与x相等，表示查找到了数据，返回该序号midnum
     *   2.如果x<a[midnum],表示要查找的数据x位于lownum与lownum-1序号之间，就不需要再去查找midnum与highnum序号之间的元素了
     * 因此，将highnum变量的值改为midnum-1,重新查找lownum与midnum-1(即highnum变量的新值)之间的数据
     *   3.如果x>a[midnum],表示要查找的数据x位于midnum+1与highnum序号之间，就不需要再去查找lownum与midnum序号之间的元素了。
     * 因此，将lownum变量的值该为midnum-1,重新查找midnum+1(即lownum变量的新值)与highnum之间的数据
     *   4.逐步循环，如果到lownum>highnum时还未找到目标数据x,则表示数组中无此数据。
     * 折半查找是一种递归过程。每折半查找一次，可使查找范围缩小一半，当查找范围缩小到只剩下一个元素，而该元素与关键字不相等，则说明
     *查找失败。在最坏的情况下，折半查找需的比较次数为O(nlog2n),其查找效率比顺序查找法要快很多。
     * @param a:数组
     * @param n:数组的长度
     * @param x:待查找的数据
     * @return
     */
    public static int findBinary(int[] a, int n, int x){
        int mid, low = 0, high = n -1;
        while (low <= high) {
            mid = (low + high)/2;
            //查找到
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //未查找到
        return -1;
    }

    /**
     * 快速排序
     * @param a
     * @param left
     * @param right
     */
    public static void quickSort(int[] a, int left, int right){
        int f,t;
        int rtemp,ltemp;
        
        ltemp = left;
        rtemp = right;
        //确定分界值
        f = a[(left + right)/2];
        while(ltemp < rtemp){
            while (a[ltemp] < f) {
                ++ltemp;
            }
            while(a[rtemp] > f){
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = a[ltemp];
                a[ltemp] = a[rtemp];
                a[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }
        if (ltemp == rtemp) {
            ltemp++;
        }
        if (left < rtemp) {
            //递归调用
            quickSort(a, left, ltemp - 1);
        }
        if (ltemp < right) {
            //递归调用
            quickSort(a, rtemp + 1, right);
        }
    }
    
    
    /**
     * 数据结构中的查找算法
     * 在不同的数据结构中，查找算法可以有不同的形式。
     */
    
    /**
     * 顺序表结构中查找
     */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static final int SIZE = 15;
    public static int[] createArrays(int size){
        int[] arrays = new int[SIZE];
        int i;
        //初始化数组
        for (i = 0; i < arrays.length; i++) {
            arrays[i] = (int)(100 + Math.random()*(100+ 1));
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        //输出排序前的数组
        for (i = 0; i < arrays.length; i++) {
            if (i != 0)
                sb.append(",");
            sb.append(arrays[i]);
        }
        sb.append("]");
        System.out.println("创建数组: " + sb.toString());
        return arrays;
    }


    public static void printPostion(int postion, int find){
        if (postion == -1) {
            System.out.println("没找到数据: " + find);
        } else {
            System.out.println("数据: " + find + "位于数组的第" + (postion + 1) + "个元素处");
        }
    }
    
    public static void printArrays(int[] arrays){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arrays.length; i++) {
            if (i != 0)
                sb.append(",");
            sb.append(arrays[i]);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {

        //要查找的数
        int x;
        //要查找的数组
        int[] arrays;
        //要查找数字的位置
        int pos; 
        Scanner input = new Scanner(System.in);

        //顺序查找
        System.out.println("******************** 顺序查找 *****************");
        //产生数组
        arrays = createArrays(SIZE);
        //输入要查找数
        System.out.println("请输入要查找的数: ");
        x = input.nextInt();
        //查找
        pos = findSequence(arrays, arrays.length, x);
        //显示结果
        printPostion(pos, x);
        
        //折半查找
        System.out.println("******************** 折半查找 *****************");
        //产生数组
        arrays = createArrays(SIZE);
        //数组排序
        System.out.println("数组排序: ");
        quickSort(arrays, 0, arrays.length - 1);
        printArrays(arrays);
        //输入要查找数
        System.out.println("请输入要查找的数: ");
        x = input.nextInt();
        //折半查找
        pos = findBinary(arrays, arrays.length, x);
        //显示结果
        printPostion(pos, x);
    }

}
