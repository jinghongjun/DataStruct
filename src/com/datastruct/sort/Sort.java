package com.datastruct.sort;

/*
    
    排序算法:将一组数据按照一定的规则进行排序，一般按照递增或递减的顺序来进行排序。
    排序算法分类
        基本排序直接对内存中的数据进行排序，而对于一些大的文件，由于计算机的内存有限，往往不能直接将其读入内存进行排序，这是可以采用多路归
并排序，将文件划分为几个能读入内存的小部分，然后分别读入进行排序，经过多次处理便可以完成大文件的排序。
    每种排序算法都有其各自的特点，往往在某些特点的场合具有比较好的执行效率，因此，读者需要根据实际问题的需要来合理选择排序算法。
          1.基本排序
                1)交换排序
                     冒泡排序
                     选择排序
                2)选择排序
                     选择排序
                     堆排序
                3)插入排序
                     插入排序
                     shell排序
                4)合并排序
           2.多路归并排序
           
           
    排序算法有很多种，每种算法都有其优缺点，可适应不同的场合。速度是决定排序算法最主要的因素，一般来说，可以从以下几方面判断一个排序
算法优略
        计算的复杂度:为了全面考虑，往往从最差、平均和最好三种情况进行评价
            对于计算的复杂度，一般依据排序数据量的大小n来度量，主要表征了算法执行速度。
                冒泡算法，平均速度为O(n2)，最坏情况下的速度为O(n2)
                快速排序法，平均速度为O(nlogn)，最坏情况下的速度为O(n2);
                选择排序法，平均速度为O(n2)，最坏情况下的速度为O(n2)
                堆排序法，平均速度为O(nlogn)，最坏情况下的速度为O(nlogn)
                插入排序法，平均速度为O(n2)，最坏情况下的速度为O(n2)
                shell排序法，平均速度为O(n3/2)，最坏情况下的速度为O(n2)
                合并排序法，平均速度为O(n2)，最坏情况下的速度为O(n2)
        系统资源的占用:主要包括内存以及其他资源的占用。一个好的排序算法应该占用少的内存资源，大部分算法都需要使用1个元素的存储单元
，用来交换数据，合并排序算法需要使用与原始序列一样长的n个元素的存储单元，因此，合并排序算法的系统资源占用要大。

  冒泡排序法、插入排序法和合并排序法都是稳定排序算法，而选择排序法，shell排序法和堆排序法都不是稳定排序算法。其实，没有某一种排序算法
是绝对好的，不同的排序算法各有忧虑。在实际应用中，需要根据实际的问题来选择合适的排序算法，如果数据量n较小的时候，可采用插入或选择排序
法，当数据量n较大的时候，则应采用时间复杂度为O(nlogn)，如快速排序、堆排序或合并排序，如果待排序的原始数据程随机分布，那么快速排速的平
均时间最短
           
*/
public class Sort {

    /*
     * 冒泡排序法
     * 冒泡排序法的思路就是交换排序，通过相邻数据的交换达到排序的目的。
     * 排序流程:
     *  1.对数组中的各数据，依次比较相邻的两个元素大小
     *  2.如果前面的数据大于后面的数据，就交换这两个数据。经过第一轮的多次比较排序后，便可把最小的数据排好
     *  3.再用同样的方法把剩下的数据逐个进行比较，最后便可按照从小到大的顺序排好数组各数据的顺序
     * 冒泡算法在对N个数据进行排序时，无论原数据有无顺序，都需要进行N-1步的中间排序。这种排序方法思路简单直观，但是缺点就是执行的
     *步骤有点长，效率不是很高。
     * 一种改进的方法，就是在每次中间排序之后，比较一下数据是否已经按照顺序排序完成，如果排序完成则退出排序，否则便继续进行冒泡排序
     * 
     */
    public static void bubbleSort(int[] a){
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                //将相邻两个数进行比较，较大的数往后冒泡
                if (a[j] > a[j + 1]) {
                    //交换相邻两个数
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            //输出每步排序结果
            printArrays(i, a);
        }
    }

    /**
     * 选择排序法
     * 选择排序法的思路就是在每一步中选取最小值来重新排序，从而达到排序的目的
     * 排序流程
     *  1.首先从原始数组中选择最小的1个数据，将其和位于第1个位置的数据交换
     *  2.接着从剩下的n-1个数据中选择次小的1个元素，将其和第2个位置的数据交换
     *  3.然后，这样不断重复，直到最后两个数据完成交换。至此，便完成了对原始数组的从小到大的排序
     * 选择排序在对N个数据进行排序时，无论原数据有无顺序，都需要进行N-1步的中间排序，这种排序方法思路很简单直观，但是缺点就是执行
     * 步骤有点长，效率也不是很高
     */
    public static void selectSort(int[] a){
        int index;
        //交换临时变量
        int temp;

        for (int i = 0; i < a.length; i++) {
            index = i;
            //寻找最小的数
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            //交换两个数
            if (index != i) {
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }

            //输出每步排序结果
            printArrays(i, a);
        }
        
    }
    
    /**
     * 插入排序法
     * 插入排序法思路对未排序的数据执行逐个插入至合适的位置而完成排序工作
     * 排序流程
     *  1.首先对数组的前两个数据进行从小到大的排序
     *  2.接着将第3个数据与排好序的两个数据比较，将第3个数据插入到合适的位置
     *  3.然后，将第4个数据插入到已排好序的3个数据中
     *  4.不断重复上述过程，知道把最后一个数据插入合适的位置，最后，便完成了对原始数组从小到大的排序
     * 插入排序算法在对N个数据进行排序时，无论原数据有无顺序，都需要N-1步的中间排序，这种方法思路很简单直观，在数据已有一定顺序
     * 的情况下，排序效率较好。但如果数据无规律则需要移动大量的数据，其排序效率也不是很好
     */
    public static void insertSort(int[] a){
        int i,j,t;
        for (i = 1; i < a.length; i++) {
            t = a[i];
            j = i -1;
            while (j >= 0 && t < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = t;

            //输出每步排序的结果
            //输出每步排序结果
            printArrays(i, a);

        }
    }
    
    /**
     * shell排序法
     * shell排序算法思路基于插入排序的思想，又称希尔排序或者缩小增量排序
     * 排序流程
     *  1.将有n个元素的数组分成n/2个数字序列，第1个数据和第n/2+1个数据为一对，........
     *  2.一次循环使每一个序列对排好顺序
     *  3.然后，再变为n/4个序列，再次排序
     *  4.不断重复上述过程，随着序列减少最后变为一个，也就完成了整个排序
     */
    public static void shellSort(int[] a){
        int i,j;
        int r,temp;
        int x = 0;

        //分解数组元素为多个序列，每次比较两数的间距，直到其值为0就结束循环
        for (r = a.length/2; r >= 1; r /= 2) {
            //按设置的间距r，分别比较对应的数组元素
            for (i = r; i < a.length; i++){
                temp = a[i];
                j = i - r;
                //在该循环中使用插入排序法对指定间距的元素进行排序
                while(j >= 0 && temp < a[j]){
                    a[j+r] = a[j];
                    j -= r;
                }
                a[j+r] = temp;
            }
        }
        
        //输出每步排序的结果
        x++;
        printArrays(x, a);
    }
    
    /**
     * 快速排序法
     * 快速排序法思路快速排序法和冒泡排序算法类似，都是基于交换排序思想的。快速排序对冒泡排序进行了改进，从而具有更高的执行效率
     * 排序流程
     *  1.首先设定一个分界值，通过该分界值将数组分成左右两部分
     *  2.将大于等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于等于分界值，而右边
     * 部分中各元素都大于等于分界值
     *  3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样将左边放置
     * 较小值，右边放置较大值。右侧的数组数据也可以做类似处理
     *  4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据
     * 排序完成后，整个数组的排序也就完成了
     * @param a:数组
     * @param left:指向数组最左边的值
     * @param right指向数组最右边的值
     * 程序中首先确定分界值为数组中间位置的值，当然也可以选在其他位置，然后按照快速排序法的思路进行处理，接着，通过递归调用，处理
     * 分界值左侧的元素和右侧的元素
     */
    public static void quickSort(int[] a, int left, int right){
        int f,t;
        int rtemp, ltemp;
        
        ltemp = left;
        rtemp = right;
        //分界值
        f = a[(left+right)/2];
        while(ltemp < rtemp){
            while(a[ltemp] < f){
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
            quickSort(a, left, ltemp - 1);
        }
        if (ltemp < right) {
            quickSort(a, rtemp + 1, right);
        }
    }
    
    /**
     * 堆排序法
     * 堆排序法思路堆排序法是基于选择排序思想的，其利用堆结构和二叉树的一些性质来完成数据的排序
     * 堆结构
     *    堆结构是一种树结构，准确地说是一个完全二叉树，在这个数中每个结点对应于原始数据的一个记录，并且每个结点应满足以下条件：
     *      如果按照从小到大的顺序排序，要求非叶结点的数据要大于或等于其左、右子结点的数据
     *      如果按照从大到小的顺序排序，要求非叶结点的数据要小于或等于其左、右子结点的数据
     * 堆排序过程
     *  一个完整的堆排序需要经过反复的两个步骤:构造堆结构和堆排序输出
     *      构造堆结构就是把原始的无序数据按前面堆结果的定义进行调整。首先，需要将原始的无序数据放置到一个完全二叉树的各个结点中
     *  这可以按照前面介绍的方法来实现
     *      然后，由完全二叉树的下层向上层逐层进行父子结点的数据进行比较，使父结点的数据大于子结点的数据。这里需要使用“帅”运算进
     *  行结点数据的调整，直到使所有结点最后满足堆结构的条件为止，帅运算这要针对非叶结点进行调整
     *  
     * @param a:数组
     * @param n:数组长度
     * 程序中反复执行构造堆结构和堆排序输出，严格遵循了前述的算法步骤
     */
    public static void heapSort(int a[], int n){
        int i,j,h,k;
        int t;
        
        //将a[0, n-1]建成大根堆
        for (i = n/2 - 1; i >=0; i--) {
            
            //第i个结点有右子树
            while(2*i + 1 < n){
                j = 2*i + 1;
                if ((j+1) < n) {
                    //左子树小于右子树，则需要比较右子树
                    if (a[j] < a[j + 1]) {
                        j++;
                    }
                }
                
                //比较i与j为序号的数据
                if (a[i] < a[j]) {
                    //交换数据
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    //堆被破坏，需要重新调整
                    i = j;
                } else {
                    //比较左右子结点均大则堆未破坏，不再需要调整
                    break;
                }
            }
        }
        
        //输出构成的堆
        System.out.println("输出堆结构:");
        printArrays(a);
        
        for (i = n - 1; i > 0; i--) {
            //与第i个记录交换
            t = a[0];
            a[0] = a[i];
            a[i] = t;
            k = 0;
            //第i个结点有右子树
            while(2 * k + 1 < i){
                j = 2 * k + 1;
                if ((j + 1) < i) {
                    //右左子树小于右子树，则需要比较右子树
                    if (a[j] < a[j+1]) {
                        //序号增加1,指向右子树
                        j++;
                    }
                }
                //比较i与j为序号的数据
                if (a[k] < a[j]) {
                    //交换数据
                    t = a[k];
                    a[k] = a[j];
                    a[j] = t;
                    //堆被破坏，需要重新调整
                    k = j;
                } else {
                    //比较左右子结点均大则堆未破坏，不再需要调整
                    break;
                }
            }
        }
    }
    
    /**
     * 合并排序法就是将多个有序数据表合并成一个有序数据表
     * 合并排序法思路首先将含有n个结点的待排序数据序列看作有n个长度为1的有序子表组成，将他们依次两两合并，得到长度为2的若干有序子表
     *然后，再对这些子表进行两两合并，得到长度为4的若干有序子表；.....重复上述过程，一直重复到最后的子表长度为n，从而完成排序过程
     * 
     * @param a:一个数组，用来保存待排序的数据
     * @param b:一个数组，用来保存合并后的数据
     * @param n:表示数组a中需要进行排序的元素总数
     * @param len:表示每个有序子表的长度
     */
    public static void mergeOne(int[] a, int[] b, int n, int len){
        int i,j,k,s,e;
        s = 0;
        while (s + len < n) {
            e = s + 2 * len - 1;
            //最后一段可能少于len个结点
            if (e >= n) {
                e = n - 1;
            }
            //相邻有序段合并
            k = s;
            i = s;
            j = s + len;
            //如果两个有序表都未结束，循环比较
            while (i < s + len && j <= e) {
                //如果较小的元素复制到数组b中
                if (a[i] <= a[j]) {
                    b[k++] = a[i++];
                } else {
                    b[k++] = a[j++];
                }
            }
            //未合并的部分复制到数组b中
            while (i < s + len) {
                b[k++] = a[i++];
            }
            while (j <= e) {
                b[k++] = a[j++];
            }
            //下一对有序段中左段的开始下标
            s = e + 1;
        }
        
        //将剩余的一个有序段从数组A中复制到数组b中
        if (s < n) {
            for (; s < n; s++) {
                b[s] = a[s];
            }
        }
        
    }
    
    /**
     * 
     * @param a:一个数组，用来保存待排序的数据
     * @param n:数组长度
     */
    public static void mergeSort(int[] a, int n){
        int h,count,len,f;
        //排序步骤
        count = 0;
        //有序序列的长度
        len = 1;
        //变量f作标志
        f = 0;
        int[] p = new int[n];
        while (len < n) {
            //交替在A和P之间合并
            if (f == 1) {
                //p 合并到a
                mergeOne(p, a, n, len);
            } else {
                //a 合并到p
                mergeOne(a, p, n, len);
            }
            //增加有序序列长度
            len = len * 2;
            //使f值在0和1之间切换
            f = 1 - f;
            count++;
            printArrays(count, a);
            
        }
        //如果进行了排序
        if (f == 1) {
            //将内存p中的数据复制回数组a
            for (h = 0; h < n; h++) {
                a[h] = p[h];
            }
        }
    }

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
        System.out.println("输出排序前的数组: " + sb.toString());
        return arrays;
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
        System.out.println("输出排序后的数组: " + sb.toString());
    }

    public static void printArrays(int step, int[] arrays){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arrays.length; i++) {
            if (i != 0)
                sb.append(",");
            sb.append(arrays[i]);
        }
        sb.append("]");
        System.out.println("第" + step + "步排序结果: " + sb.toString());
    }

    static final int SIZE = 10;
    public static void main(String[] args) {
        int[] arrays;

        //冒泡排序
        System.out.println("**************** 冒泡排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        bubbleSort(arrays);
        //输出排序后的数组
        printArrays(arrays);

        //选择排序
        System.out.println("**************** 选择排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        selectSort(arrays);
        //输出排序后的数组
        printArrays(arrays);
        
        //插入排序
        System.out.println("**************** 插入排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        insertSort(arrays);
        //输出排序后的数组
        printArrays(arrays);
        
        //shell排序
        System.out.println("**************** shell排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        shellSort(arrays);
        //输出排序后的数组
        printArrays(arrays);
        
        //快速排序
        System.out.println("**************** 快速排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        quickSort(arrays, 0, arrays.length - 1);
        //输出排序后的数组
        printArrays(arrays);
        
        //堆排序
        System.out.println("**************** 堆排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        heapSort(arrays, arrays.length);
        //输出排序后的数组
        printArrays(arrays);
        
        //合并排序
        System.out.println("**************** 合并排序 ****************");
        arrays = createArrays(SIZE);
        //排序操作
        mergeSort(arrays, arrays.length);
        //输出排序后的数组
        printArrays(arrays);

    }

}
