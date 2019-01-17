package sort;/**
 * Created by DELL on 2018/11/6.
 */

/**
 * user is lwb
 *
 * 在快速排序中，执行一次partition，确定一个元素得最终位置，这个位置也就是数组中得下标，
 * 如果按照降序排列得话，那么这个下标值，就是有序序列得标号或者排名了。
 *
 **/


public class Kth {


    public static void main(String[] args){
        int[] data = {4,3,2,1,9,8,6,7,5,10,52,31,47,22};
//        int pa = partition_1(data,0,data.length-1);
//        System.out.println(pa);
//        System.out.println("=========");
        int k = quick_sort(data,0,data.length-1,0);
        System.out.println(k);
//        for(int i : data){
//            System.out.println(i);
//        }
    }


    private static int quick_sort(int[] data,int begin, int end,int k){
        if(begin>=end) return data[begin];
        int pa = partition_2(data,begin,end,k);
        if(k==pa){
            return data[pa];
        } else if(k>pa){
            return quick_sort(data,pa+1,end,k);
        }else {
            return quick_sort(data,begin,pa-1,k);
        }
    }


    private static int partition_2(int[] data, int begin, int end,int k){
        int temp = data[begin];
        while (begin<end){
            while (begin<end && temp >= data[end]){
                end --;
            }
            data[begin] = data[end];
            begin++;
            while (begin<end && temp <= data[begin]){
                begin++;
            }
            data[end] = data[begin];
        }
        data[end] = temp;
        return end;
    }


}
