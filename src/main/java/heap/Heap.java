package heap;/**
 * Created by DELL on 2018/12/13.
 */

/**
 * user is lwb
 **/


public class Heap {

    private int count;//堆中现有数据个数
    private int n;//堆最大可以容纳数据量
    private int[] datas;//堆中存放的数据 从索引为1的位置开始存放数据。
    private Compartor compartor;



    public Heap(int capacity){
        this(capacity, new Compartor() {
            public boolean control(int parent, int son) {
                return (parent < son);
            }
        });
    }


    public Heap(int capacity, Compartor compartor){
        Utils.checkNull(capacity);
       // Utils.checkNull(sources);
        Utils.checkNull(compartor);

        this.n = capacity;
        this.compartor = compartor;
        this.datas = new int[capacity + 1];
    }


    public static  Heap getMinHeap(int capacity){
        return new Heap(capacity, new Compartor() {
            public boolean control(int parent, int son) {
                return parent > son;
            }
        });
    }

    public void init(int[] sources){
        Utils.checkNull(sources);
        if(sources.length > n){
            throw new IllegalArgumentException("length tai da ");
        }
        for (int i = 0; i < sources.length; i++) {
            datas[i + 1] = sources[i];
            count ++;
        }
    }

    private void swap(int targetIndex,int sourceIndex){
        int temp = datas[targetIndex];
        datas[targetIndex] = datas[sourceIndex];
        datas[sourceIndex] = temp;
    }

    //插入操作，将数据插入到数组的最后一个位置，也就是堆的最后叶子结点的位置，然后按照从下到上，进行堆化，使插入的这个元素，融入堆中。
    public void insert(int data){
        if(count + 1 > n){
            System.out.println("堆满了");
            return;
        }
        int currentIndex = ++ count ;
        datas[currentIndex] = data;
        heapfiyFromDownToUp(data);
    }

    //删除堆顶元素
    public void delete(){
        if(count < 1){
            System.out.println("堆空了");
            return;
        }
        swap(1,count);
        count --;
        heapfiyFromUpToDown(1);
    }

    public void heapSort(){
        int count = this.count;
        for (int i = 0; i < count; i++) {
            delete();
        }
        printHeapRevert(count);
    }

    public int getHeapTop(){
        if(count > 1){
            return datas[1];
        }else{
//            throw new IllegalStateException("no data in heap");
            return Integer.MIN_VALUE;
        }
    }

    public int getCount(){
        return count;
    }

    public int getCapacity(){
        return n;
    }



    public void buildHeap_FromDownToUp(){
        int i = 1;
        int count = this.count;
        this.count = 0;
        while (i <= count){
            insert(datas[i]);
            i++;
        }
    }

    public void buildHeap_FromUpToDown(){
        int count = this.count;
        for (int i = count / 2; i >= 1 ; i--) {
            heapfiyFromUpToDown(i);
        }
    }

    public void printHeap(){
        System.out.println();
        for (int i = 1; i <= count; i++) {
            System.out.print(datas[i]+"   ");
        }
        System.out.println();
    }

    private void printHeapRevert(int count){
        System.out.println();
        for (int i = count; i > 0; i--) {
            System.out.print(datas[i]+"   ");
        }
        System.out.println();
    }




    //从下向上堆化。
    private void heapfiyFromDownToUp(int key){
        int currentIndex = count ;
        while (currentIndex > 1){
            if(compartor.control(datas[currentIndex / 2], datas[currentIndex])){
                swap(currentIndex,currentIndex / 2);
                currentIndex = currentIndex /2;
            }else{
                break;
            }
        }
    }


    private void heapfiyFromUpToDown(int begin){
        int currentIndex = begin;
        int maxPosition = begin;
        while (currentIndex <= count / 2){
            if(currentIndex*2 <= count && compartor.control(datas[currentIndex], datas[currentIndex*2])) maxPosition = currentIndex * 2;
            if(currentIndex*2 + 1 <= count && compartor.control(datas[maxPosition] , datas[currentIndex*2 + 1])) maxPosition = currentIndex * 2 + 1;
            if(maxPosition != currentIndex){
                swap(currentIndex,maxPosition);
                currentIndex = maxPosition;
            }else{
                break;
            }
        }
    }

    public interface Compartor{
        boolean control(int parent, int son);
    }


}
