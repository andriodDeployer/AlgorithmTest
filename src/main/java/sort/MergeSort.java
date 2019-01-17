package sort;/**
 * Created by DELL on 2018/11/5.
 */

/**
 * user is lwb
 *
 *
 * 归并排序的排序过程：在合并的过程中实现的。递归的过程只不过将大问题分解成小问题，但是每个合并的过程是完成排序的主要的过程，
 * 归并中合并的过程，就是将两个有序的子序列合并成一个有序序列的过程，合并的子序列，有小变大，直至将两个半序列合并成一个完整序列。(类似于链表的合并一样{@link linnerstructer.linkedlist.Node})
 * 因为排序的过程主要在合并，所以，分析归并排序的性能指标，也只需分析合并的过程即可。
 *
 * 是否是原地排序：不是，需要额外开辟新的空间来辅助排序，每次合并都需要开辟一个大小为n的空间，因为这个排序过程，需要合并logn次，那是不是说，需要开辟的空间就是n*logn呢？
 * 答案是否定的，因为，在一次合并结束后，这次合并开辟的空间，会释放掉，所以所有logn次开辟的空间的和，和一次合并排序开辟的空间大小是一样的，为O(n)
 *
 * 是否是稳定的：这个取决于合并过程中将两个有序子序列合并成一个有序序列的过程，这个是可控的，是稳定的。
 * 时间复杂度：这个归并排序，递归的深度为logn，也就是需要合并logn次，每次合并需要O(n)的时间复杂度，所以总共的时间复杂度为O(n*logn)。其实这种计算方式并不完全精确
 *  真实的计算方式：T(n) = 2*T(n/2) + n
                     = 2*(2*T(n/4) + n/2) + n = 4*T(n/4) + 2*n
                     = 4*(2*T(n/8) + n/4) + 2*n = 8*T(n/8) + 3*n
                     = 8*(2*T(n/16) + n/8) + 3*n = 16*T(n/16) + 4*n
                     ......
                     = 2^k * T(n/2^k) + k * n
                     ......
                     当k=log2n时，T(n) = n+nlog2n=O(nlogn)

 *
 *
 *
 **/


public class MergeSort {

    public static void main(String[] args){
        int[] data = {1,3,2,9,4,8,6,7,5};
        merge_sort(data,0,data.length-1);
        for(int i : data){
            System.out.println(i);
        }



//        int[] k = {1,3,5,2,4,6};
//        merge(k,0,5);
//
//        for(int i : k){
//            System.out.println(i);
//        }
    }



    private static void merge_sort(int[] data, int begin, int end){
        if(begin>=end) return;
        merge_sort(data,begin,(begin+end)/2);
        merge_sort(data,(begin+end)/2+1,end);
        merge(data,begin,end);
    }

    private static void merge(int[] data, int begin, int end){
        int[] b = new int[end - begin + 1];
        int i = begin;
        int j = (begin+end)/2 +1;
        int k = 0;
        while (i <= (begin+end)/2 && j<=end){
            if(data[i] < data[j]){
                b[k] = data[i];
                i++;
            }else{
                b[k] = data[j];
                j++;
            }
            k++;
        }

        while (i<=(begin+end)/2){
            b[k++] = data[i++];

        }

        while (j<=end){
            b[k++] = data[j++];
        }


        for(i=begin;i<=end;i++){
            data[i] = b[i-begin];
        }

    }




}
