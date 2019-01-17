package sort;/**
 * Created by DELL on 2018/10/25.
 */

/**
 * user is lwb
 *
 * 比较，交换的方式。无论原来数据是否有序，比较的次数时不变的，交换的次数可能会少一些。
 * 一次排序，确定一个当前最大/最小数，并置于一端。
 *
 *
 * 冒泡采用的是相邻的两个元素进行比较，如果进行比较的两个元素值相同的话，不进行交换，那么，相同的两个元素的前后相对位置就不会发生变化，也就是稳定的。
 *
 * 为了提高冒泡排序，在有序序列排序的性能，可以采用标志位记录是否进行过交换，如果没有进行交换，说明：序列已经有序，直接退出排序。
 *
 *  稳定性：稳定
 *  是否原地排序：是。
 *  对冒泡排序进行优化后：
 *  时间复杂度:
 *      最好的情况下(有序的情况下)：O(n)
 *      最坏的情况下(无序的情况下)：O(n^2)
 *
 *
 *      如果a < j,且a[i]<=a[j]，那么a[i]和a[j]就是有序对。有序对的个数，称为有序度。
 *      如果a < j,且a[j]> a[j]，那么a[i]和a[j]就是无序对。无序对的个数，称为无序度。
 *      如果一个序列是有序的，那么这个序列的有序度，叫做满有序度，满序度 =  n*(n-1)/2
 *      冒泡排序的比较交换次数等于逆序度。
 *
 *  冒泡排序：将有序子序列慢慢扩大，直到这个序列都有序。而且有序的子序列是全局有序的。
 *
 *
 **/


public class BubboSort {


    public static void main(String[] args){
        int[] data = {1,3,2,9,4,8,6,7};
        //data = non_maopao(data);
        data = mappao(data);
        for(int i : data){
            System.out.println(i);
        }
    }


    public static int[] non_maopao(int [] data){

        for(int i=0; i<data.length; i++){
            for(int j=i+1; j<data.length; j++){
                if(data[i] > data[j]){
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }


    public static int[] mappao(int[] data){
        for(int i=0; i<data.length; i++){
            boolean flag = false;
            for(int j=0; j<data.length - i -1; j++){
                if(data[j] > data[j+1]){
                    int tmep = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmep;
                    System.out.println("dddddd");
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("在第"+i+"次退出！");
                break;
            }
        }
        return data;
    }
}
