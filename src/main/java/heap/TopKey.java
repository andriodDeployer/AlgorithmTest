package heap;/**
 * Created by DELL on 2018/12/14.
 */

/**
 * user is lwb
 **/

//取出最大的前k个元素的
public class TopKey {
    public static void main(String[] args) {
        int[] datas = {1,2,3,4,5,6,7,8,9,10};
        Heap minHeap = Heap.getMinHeap(8);//使用小顶堆
        for (int i = 0; i < datas.length; i++) {
            if(datas[i] > minHeap.getHeapTop()){
                if(minHeap.getCount() == minHeap.getCapacity()){
                    minHeap.delete();
                }
                minHeap.insert(datas[i]);
            }
        }
        minHeap.printHeap();
    }
}
