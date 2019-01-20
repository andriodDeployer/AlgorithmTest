package thoughtofalgorithmic.divide;/**
 * Created by DELL on 2019/1/17.
 */

/**
 * user is lwb
 **/


public class NiXuDui {


    public static void main(String[] args) {
        int[] a = {2,4,3,1,5,6};
        NiXuDui nxd = new NiXuDui();
        nxd.mergeSortCounting(a,0,5);
        System.out.println(nxd.num);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }



    }

    int num = 0;
    private void mergeSortCounting(int[] a,int begin,int end){
        num = 0;
        if(begin >= end){
            return;
        }

        int mid = (begin + end) / 2;
        mergeSortCounting(a, begin, mid);
        mergeSortCounting(a, mid+1, end);
        merge(a,begin,mid,end);



    }

    private void merge(int[] a, int begin, int mid, int end) {
        int temp[] = new int[end - begin +1];
        int k = 0;
        int i = begin;
        int j = mid + 1;
        while (i<=mid && j<=end){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                num += (mid -i +1);
                temp[k++] = a[j++];
            }
        }

        while (i<= mid){
            temp[k++] = a[i++];
        }

        while (j <= end){
            temp[k++] = a[j++];
        }


        for (int l = begin; l <=end; l++) {
            a[l] = temp[l-begin];
        }
    }

}
