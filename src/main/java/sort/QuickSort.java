package sort;/**
 * Created by DELL on 2018/11/5.
 */

/**
 * user is lwb
 *
 * 快速排序类似归并，也是一种分治的思想，快速排序的核心功能实现，在partition方法的实现上，
 * 这个方法的功能，是从给定的序列中，从中随机找出一个值，将整个序列以这个值为中间值分成两部分，一部分大于整个值，一部分小于这个中间值，
 * 执行一次partition方法，可以全局的确定序列中一个值的最终位置，就是这个中间值的位置，因为是全局的，所以确定这个中间值的最终位置的时间复杂度为O(子序列的长度)
 *
 * 与归并不同的是，快速排序执行一次partition方法可以确定一个值的全局位置，也就是最终位置，不用像归并那样，需要一个合并的过程，因为不合并，每个元素的最终物位置都无法确定。
 * 归并是先将大问题逐个展开成小问题，求解小问题的局部解，然后将所有局部解合并一起，得到最终全局的解。快速排序，也是将大问题展开成小问题，求解小问题的解，就是最终的全局的解，
 * 所以无需在进行合并的过程。
 * 归并排序，在完成分解之后，开始排序的操作，也就是合并的过程。而快速排序，则是一开始就执行partition操作，确定一个数据的最终位置，然后按照相同的逻辑处理子问题。
 * 换句话说，归并排序是自下而上的，解决问题，而快速排序是自上而下开始的。
 *
 *
 * 分析快速排序的性能指标，只要就是分析partition方法的性能指标。
 * 是否是原地排序：在paitition的实现过程中，没有开辟新的空间，所以，属于原地排序。
 *
 * 是否是稳定的：因为partition是采用比较移动，但是比较是从另一端开始比较的，如果比较结果合适的，就进行交换，所以在交换的过程中，稳定性是无法保证的。
 *
 * 空间复杂度：因为属于原地排序，所以空间复杂度为O(1)
 *
 * 时间复杂度：对于时间复杂度的分析，要分为最差和一般，对于最差的情况(序列是有序的，每次选取pivot从头部/尾部选取)，就是在partition方法选取中间值选取的不好导致的，如果每次选取的povit都在一个序列的一端，
 * 那么就起不到递归将大问题划分小问题的作用了，因为大问题经过划分后，分解成规模为1和n-1的两个问题。但是这种情况是很少发生的。所以其时间复杂度为平均时间复杂度O(nlogn)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 **/


public class QuickSort {



    public static void main(String[] args){
        int[] data = {4,3,2,1,9,8,6,7,5,10,52,31,47,22};
//        int pa = partition_1(data,0,data.length-1);
//        System.out.println(pa);
//        System.out.println("=========");
        quick_sort(data,0,data.length-1);
        for(int i : data){
            System.out.println(i);
        }
    }


    private static void quick_sort(int[] data,int begin, int end){
        if(begin>=end) return;
        int pa = partition_2(data,begin,end);
        if(pa-1>begin) quick_sort(data,begin,pa-1);
        if(end>pa+1) quick_sort(data,pa+1,end);
    }

    private static int partition_1(int[] data, int begin, int end){
        int temp = data[begin];
        int i;
        while (begin <= end){
            while (data[end] > temp){
                end--;
            }

            i = data[begin];
            data[begin] = data[end];
            data[end] = i;
            begin++;
            if(begin>end){
                begin--;
                break;
            }

            while (data[begin]<temp){
                begin++;
            }

            i = data[begin];
            data[begin] = data[end];
            data[end] = i;
            end--;
        }
        return begin;
    }




    private static int partition_2(int[] data, int begin, int end){
        int temp = data[begin];
        while (begin<end){
            while (begin<end && temp <= data[end]){
                end --;
            }
            data[begin] = data[end];
            begin++;
            while (begin<end && temp >= data[begin]){
                begin++;
            }
            data[end] = data[begin];
        }
        data[end] = temp;
        return end;
    }












}
