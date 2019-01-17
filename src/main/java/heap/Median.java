package heap;/**
 * Created by DELL on 2018/12/13.
 */

/**
 * user is lwb
 **/


public class Median {
    public static void main(String[] args) {
        int count = 107;
        int[] datas = new int[count];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = i+1;
        }
        Heap max = new Heap(count);
        Heap min = new Heap(count, new Heap.Compartor() {
            public boolean control(int parent, int son) {
                return (parent > son);
            }
        });
        for (int i = 0; i < datas.length; i++) {
            int current = datas[i];
            if(current > min.getHeapTop()){
                min.insert(current);
            }else{
                max.insert(current);
            }
            while (min.getCount() > max.getCount()){
                int minnum = min.getHeapTop();
                min.delete();
                max.insert(minnum);
            }
            while (max.getCount() - min.getCount() > 2){
                int maxnum = max.getHeapTop();
                max.delete();
                min.insert(maxnum);
            }
        }
        System.out.println(max.getHeapTop());
    }
}
