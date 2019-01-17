package sort;/**
 * Created by DELL on 2018/11/5.
 */

/**
 * user is lwb
 * 选择排序：
 *  是否原地排序：是
 *  是否稳定：不稳定，因为选择排序，选择出一个最小的数据，与当前数据进行位置互换，没有考虑数据相同的情况。
 *  时间复杂度：
 *      最好和最坏都是O(n^2)
 *
 *
 *
 **/


public class SelectionSort {

    public static void main(String[] args){
        int[] data = {1,3,2,9,4,8,6,7,5};
        //data = non_maopao(data);
        data = selection(data);
        for(int i : data){
            System.out.println(i);
        }
    }


    private static int[] selection(int[] data){
        for(int i=0; i<data.length; i++){
            int minIndex = i;
            for(int j=i+1; j<data.length; j++){
                if(data[minIndex]>data[j]){
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        return data;
    }
}
