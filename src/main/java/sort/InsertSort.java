package sort;/**
 * Created by DELL on 2018/11/5.
 */

/**
 * user is lwb
 *
 * 插入排序：
 *  是否原地排序：是，只需要一个temp；
 *  是否稳定：插入排序是一个比较的过程，将后面的元素，逐个插入到前面的有序序列中，如果发现数据相同的话，可以将数据插入到相同数据的后面，保证稳定性；
 *  时间复杂度：
 *      在最好的情况下(有序的情况下)：每次插入只需比较一次，确定无序进行插入，退出子循环，时间复杂度O(n).
 *      在最坏的情况下(无序的情况下)：每次插入需要比较多次，时间复杂度为O(n^2)
 *  插入排序会产生有序子序列，子序列慢慢扩大，直到整个序列有序。但是这个子序列不是全局有序的。
 *
 *
 *
 *
 *
 *
 **/


public class InsertSort {

    public static void main(String[] args){
        int[] data = {1,3,2,9,4,8,6,7,5};
        //data = non_maopao(data);
        insert(data);
        for(int i : data){
            System.out.println(i);
        }
    }


    private static void insert(int[] data){
        if(data.length<2){
            return ;
        }
        for(int i=1; i<data.length; i++){
            int temp = data[i];
            int j = i-1;
            for(; j>=0; j--){
                if(data[j] > temp){
                    data[j+1] = data[j];
                }else{
                    break;
                }
            }
            data[j+1] = temp;
        }
    }

}
