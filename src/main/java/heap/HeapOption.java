package heap;/**
 * Created by DELL on 2018/12/13.
 */

/**
 * user is lwb
 **/


public class HeapOption {




    public static void main(String[] agrs){
        int[] datas = {1,4,7,8,9};
        Heap heap = new Heap(10, new Heap.Compartor() {
            public boolean control(int target, int source) {
                return (target > source);
            }
        });
        heap.init(datas);
        heap.buildHeap_FromDownToUp();
        //heap.buildHeap_FromUpToDown();
       // heap.insert(10);
       // heap.delete();
       // heap.printHeap();
        heap.heapSort();
//        for (int i = 0; i < 5; i++) {
//            heap.delete();
//            heap.printHeap();
//        }
    }







}
