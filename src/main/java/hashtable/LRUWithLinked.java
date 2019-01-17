package hashtable;/**
 * Created by DELL on 2018/11/8.
 */

/**
 * user is lwb
 **/


public class LRUWithLinked {

    private static Node header = new Node(null);
    private static int counter = 0;
    private static int capcity = 5;

    static class Node {
        Integer data;
        Node pre;
        Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            addNode(i);
        }

       // deleteValue(4);
        addNode(5);
        System.out.println();
        System.out.println();
        System.out.println();
        while (header.next != null){
            System.out.print(header.next.data+"      ");
            header = header.next;
        }
    }


    public static void addNode(Integer value){
        Node next = null;
        Node findedNode = null;
        Node current = header;
        while (current.next != null){
            next = current.next;
            if(next.data == value){
                next.pre.next = next.next;
                next.next.pre = next.pre;
                findedNode = next;
            }
            current = next;
        }

        if(findedNode == null){
            findedNode = new Node(value);
            System.out.print("没到了，");
            if(counter + 1 > capcity){
                System.out.println("满了要删除旧值");
                //删除头元素
                header.next.next.pre = header;
                header.next = header.next.next;
            }else{
                System.out.println("元素数量增加1");
                counter ++;
            }
        }else{
            System.out.println("找到了");
        }
        findedNode.next = current.next;
        current.next = findedNode;
        findedNode.pre = current;
    }


    public static void getValue(int k){
        Node current = header;
        while (current.next != null){
            if(header.next.data == k){
                System.out.println("找到了元素"+k);
                break;
            }
            current = current.next;
        }
        System.out.println("没有找到指定的元素");
    }

    public static void deleteValue(int k){
        Node current = header;
        while (current.next != null){
            if(current.next.data == k){
                System.out.println("找到了要删除元素"+k);
                current.next = current.next.next;
                if(current.next != null){
                    current.next.pre = current;
                }
                counter --;
                return;
            }
            current = current.next;
        }
        System.out.println("没有找到要删除的元素");
    }





}
