package hashtable;/**
 * Created by DELL on 2018/11/8.
 */

/**
 * user is lwb
 **/


public class HashTableWithLinked {

    private int capcity = 5;

    public int getCapcity() {
        return capcity;
    }

    private int hash(int key){
        return key % capcity;
    }

    //为什么要转型呢？
    private Node<Integer,String>[] data = (Node<Integer,String>[])new Node[capcity];

    public HashTableWithLinked() {
        for (int i = 0; i < capcity; i++) {
            data[i] = new Node<Integer, String>(null,null);
        }

    }

    static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        HashTableWithLinked ha = new HashTableWithLinked();
        for (int i = 0; i < 15 ; i++) {
            ha.addNode(i,""+i);
        }

        ha.extendCapcityOnce();
        System.out.println("capcity  "+ha.capcity);

        ha.extendCapcityOnce();
        System.out.println("capcity  "+ha.capcity);


        for (int i = 0; i <15 ; i++) {
            ha.get(i);
        }




    }


    public void addNode(Integer key,String value){
        int index = hash(key);
        Node header = data[index];
        while (header.next != null){
            if(header.next.key == key){
                System.out.println("已经存在，修改即可");
                header.next.value = value;
                return;
            }
            header = header.next;
        }
        System.out.println("新增");
        Node<Integer,String> newNode = new Node<Integer, String>(key,value);
        newNode.next = header.next;
        header.next = newNode;
    }


    public void get(int key){
        int index = hash(key);
        Node<Integer,String> header = data[index];
        while (header.next != null){
            if(header.next.key == key){
                System.out.println("找到了,key:"+key+",value:"+ header.next.value);
                return;
            }
            header = header.next;
        }
        System.out.println("没有找到");
    }


    private void extendCapcityOnce(){
        int oldCapcity = capcity;
        capcity = oldCapcity << 1;
        Node<Integer,String>[] temp = (Node<Integer, String>[]) new Node[capcity];

        for (int i = 0; i <oldCapcity ; i++) {
            Node<Integer,String> header = data[i];
            while (header.next != null){
                Integer key = header.next.key;
                int index = hash(key);
                if(temp[index] == null){
                    temp[index] = new Node<Integer, String>(null,null);
                }
                Node newHeader = temp[index];
                while (newHeader.next != null){
                    newHeader = newHeader.next;
                }
                Node oldNode = header.next;
                header.next = header.next.next;
                oldNode.next = newHeader.next;
                newHeader.next = oldNode;
                if(header.next == null){
                    break;
                }
            }
        }
        data = temp;
    }
}
