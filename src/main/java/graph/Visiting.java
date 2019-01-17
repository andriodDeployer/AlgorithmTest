package graph;

import graph.exception.EmptyException;
import graph.exception.FullException;

/**
 * Created by DELL on 2018/12/17.
 */
public interface Visiting {

    void addEle(int data);
    boolean isFull();
    boolean isEmpty();
    int getEle();
    Visiting init();
    void remove();

    Visiting Queue = new Visiting() {
        private int[] visiting_Queue = new int[100];
        int head,tail = 0;
        public void addEle(int data) {
            if(isFull()){
                throw new FullException("队列已满");
            }
            visiting_Queue[tail++] = data;
        }

        public boolean isFull() {
            return  tail == visiting_Queue.length;
        }

        public boolean isEmpty() {
            return head == tail && head != 0;
        }


        public int getEle() {
            if(isEmpty()){
                throw new EmptyException("队列已经空了");
            }
            return visiting_Queue[head++];
        }

        public Visiting init() {
            head=0;
            tail = 0;
            return this;
        }

        public void remove() {

        }
    };

    Visiting Stack = new Visiting() {
        private int[] visiting_Stack = new int[100];
        int tail = 0;
        public void addEle(int data) {
            if(isFull()){
                throw new FullException("栈已满");
            }
            visiting_Stack[tail++] = data;
        }

        public boolean isFull() {
            if(tail == visiting_Stack.length)
                return true;
            return false;
        }

        public boolean isEmpty() {
            if(tail == 0)
                return true;
            return false;
        }


        public int getEle() {
            if(isEmpty()){
                throw new EmptyException("栈已经空了");
            }
            return visiting_Stack[tail-1];
        }

        public Visiting init() {
            tail = 0;
            return this;
        }

        public void remove() {
            if(isEmpty()){
                throw new EmptyException("栈已经空了");
            }
            tail --;
        }
    };

}



