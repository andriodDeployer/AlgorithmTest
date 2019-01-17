package sort;/**
 * Created by DELL on 2018/11/6.
 */

/**
 * user is lwb
 *
 * 桶排序是一种对数据有要求的排序，要求数据的值大小分布比较均匀的情况。
 * 定义K的桶(容器)，存放指定范围的数据，各个桶指定的范围相邻但不重叠，
 * 对n的数据采用桶排序进行排序，定义K个桶。
 * 1.遍历一遍所有数据，将数据按照桶指定的范围，存放到指定的桶中。时间复杂度为O(n)
 * 2.对每个桶中的数据按照快速排序进行排序，每个桶排序的时间复杂度为O((n/k)log(n/k)),所有桶的排序时间复杂度总和为O(k*(n/k)*log(n/k))=O(nlog(n/k)),
 *   当k的个数接近n时，桶排序的时间复杂度为O(n)
 *
 *
 *
 * 主要使用的场景为：
 *      数据分布比较均匀的情况，且数据量特别大(不适合全部放到内存中)，需要借助外部存储，将数据存放到磁盘上，将数据一部分一部分(n/k)的放入内存中进行排序，
 *      时间复杂度为O(n),空间复杂度为O(n/k);
 *
 **/


public class BuketSort {

    public static void main(String[] args){
        int[] data = {1,3,2,9,4,8,6,7,5,11,15,12,14,16,19,18,17,23,25,21,20,69,64,62,35,67,99,52,78,95,43,39,85,92};
        //data = non_maopao(data);
       // insert(data);
        for(int i : data){
            System.out.println(i);
        }
    }


    public static void buket(int[] data){

        int buketCount = 9;



    }


}
