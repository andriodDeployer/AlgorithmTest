package search;/**
 * Created by DELL on 2018/11/6.
 */

/**
 * user is lwb
 *
 *
 * 折半查找：对数据的要求就是被查找的序列是有序的，
 * 查找的时间复杂度是O(logn)，也就是说从一个数量为2^32(42亿)的序列，最多需要32次比较就能找到这个数据了。
 *
 * 使用二分查找的限制：
 *  1.数据的存储结构必须是可以进行随机访问的顺序结构，数组。
 *  2.数据必须是有序的，对于无需的数据要想使用二分查找的话，必须先进行排序，虽然排序相对与二分查找，时间复杂度很高，但是均摊到二分查找上，时间复杂度就会降低很多。
 *  3.如果数据需要进行频繁插入和删除的话，需要保证插入和删除后，序列仍然是有序的，那么就要维护队列的有序性，针对这种动态数据集合，
 *  无论那种方法，维护有序的成本都是比较高的，所以针对动态的数据集合，不适合使用二分查找。
 *  4.数据量小的不适合二分查找，当数据量很小是，直接顺序遍历，即可完成查找，查找逻辑简单，耗时也很低，
 *      使用顺序遍历进行查找，比较的次数比较多，如果比较的过程很耗时的话，还是要使用二分查找，因为二分查找的比较次数很少，节省的时间就很少了。
 *  5.数据量大的序列，也不适合进行二分查找，这个主要因为二分查找的数据结构特征引起的，因为二分查找需要数据结构必须是连续的存储空间，
 *  如果数据量大的话，从内存中申请较大连续空间是很难满足的，即使内存中剩余2G的空间，但是要想申请1G的连续空间也是很难的。
 *
 *
 *  如果使用链表作为存储结构实现二分查找的话，由于链表不支持随机访问，那么，获取中间点的值的时间复杂度，分别为n/2,n/4,n/8...1,共logn次，加起来的话(等比数列求和)
 *  共n-1,时间复杂度为O(n-1)
 *
 *
 *  凡是用二分查找的情况，都可以使用散列表和二叉查找树来实现，几变二分查找节省内存，但是现实开发中，内存紧张的情况并不多，而且二分查找依赖的顺序结构的数据结构，这是一个很大的限制。
 *  那么二分查找是不是就没有用了？其实二分查找主要使用的场景是：“近似”查找的问题上，如查找小于等查找值的最后一个值，大于等于查找值的第一个。
 *  ip查找。
 *
 *
 **/


public class BinarySearch {

    public static void main(String[] args){
        int[] data = {1,2,3,4,4,6,7,8,9,10,11,12,15,16,17,18,19,20};
//        int index = binarySearchRe(data,0,data.length-1,21);
//        int index = binarySearch_first_eq(data,4);
//        int index = binarySearch_last_eq(data,4);
        int index = binarySearch_first_gteq(data,5);
//        int index = binarySearch_last_lteq(data,5);
        System.out.println(index);


    }

    public static int binarySearch(int[] data,int k){
        int temp = data[0];
        if(temp == k){
            return 0;
        }
        temp = data[data.length-1];
        if(temp == k){
            return data.length - 1;
        }
        int begin = 0;
        int end = data.length-1;
        int pivot = (begin + end)/2;
        temp = data[pivot];
        while (temp != k && pivot<=end && pivot>=begin){
            if(k < temp){
                end = pivot-1;
            }else{
                begin = pivot+1;
            }
            pivot = (begin+end)/2;
            temp = data[pivot];
        }
        if(temp == k){
            return pivot;
        }
        return -1;
    }


    public static int binarySearch_1(int[] data,int k){
        int begin = 0;
        int end = data.length-1;
        while (begin<=end) {
            //int mid = (begin + end) / 2;//如果begin和end很大的话，那么两者之和有可能会溢出，可以换种写法 如下：
            int mid = begin + (end - begin)/2;//对于除2操作，可以用右移来实现。虽然结果一样，但是右移明显比除2更高效。
            if (k == data[mid]) {
                return mid;
            } else if (k < data[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }





    private static int binarySearch_first_eq(int[] data,int k){
        int begin = 0;
        int end = data.length -1;
        while (begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(k == data[mid]){
                while (data[--mid] == k){}
                return ++mid;
            }else if(k < data[mid]){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return -1;
    }
    private static int binarySearchRe(int[] data,int begin,int end,int k){
        if(begin>end){
            return -1;
        }
        int mid = (begin+end)/2;
        if(data[mid] == k){
            return mid;
        }else if(data[mid]>k){
            return binarySearchRe(data,begin,mid-1,k);
        }else {
            return binarySearchRe(data,mid+1,end,k);
        }
    }




    private static int binarySearch_last_eq(int[] data,int k){
        int begin = 0;
        int end = data.length -1;
        while (begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(k == data[mid]){
                while (data[++mid] == k){}
                return --mid;
            }else if(k < data[mid]){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return -1;
    }


    private static int binarySearch_first_gteq(int[] data, int k){
        int begin = 0;
        int end = data.length -1;
        while (begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(k == data[mid]){
                while (data[++mid] == k){}
                return --mid;
            }else if(k < data[mid]){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return begin;
    }


    private static int binarySearch_last_lteq(int[] data,int k){
        int begin = 0;
        int end = data.length -1;
        while (begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(k == data[mid]){
                while (data[++mid] == k){}
                return --mid;
            }else if(k < data[mid]){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return end;
    }

    private static int binarySearch_last_lteq_1(int[] data,int k){
        int begin = 0;
        int end = data.length -1;
        while (begin <= end){
            int mid = begin + ((end - begin) >> 1);
            if(k <= data[mid]){
                if(mid == 0 || data[mid-1] < k){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else {
                begin = mid + 1;
            }
        }
        return -1;
    }




}
