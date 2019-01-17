package linnerstructer.queue;/**
 * Created by DELL on 2018/10/24.
 */

/**
 * user is lwb
 **/


public class CycleQueue {
    int itemsLength = 7;
    public Integer[] items = new Integer[itemsLength];
    int headIndex = 0;
    int tailIndex = 0;

    int count = 0;

    boolean isFull(Integer headIndex, Integer tailIndex ){
        return tailIndex == headIndex;
    }

    int incIndex(Integer index){
        index ++;
        if(index == itemsLength){
            index = 0;
        }
        return index;
    }


//存在一个空间的浪费。
    boolean enqueue(Integer item){
        if((tailIndex+1)% itemsLength == headIndex ){
            System.out.println("full....");
            return false;
        }
        items[tailIndex] = item;
        tailIndex = incIndex(tailIndex);
        return true;
    }

    boolean enqueue2(Integer item){
        if(count == itemsLength){
            System.out.println("full ....");
            return false;
        }
        items[tailIndex] = item;
        tailIndex = incIndex(tailIndex);
        count++;
        return true;
    }


    Integer dequeue2(){
        if(count == 0){
            System.out.println("empty.....");
            return null;
        }

        int item =  items[headIndex];
        count--;
        headIndex = incIndex(headIndex);
        return item;
    }




    public static void main(String[] args){
        CycleQueue queue = new CycleQueue();
        int i = 0;
        for(; i < 8; i++){
            queue.enqueue2(i);
        }
    }

}
