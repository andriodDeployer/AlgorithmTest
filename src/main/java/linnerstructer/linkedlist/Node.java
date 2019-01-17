package linnerstructer.linkedlist;/**
 * Created by DELL on 2018/10/23.
 */

/**
 * user is lwb
 **/


public class Node {
    public  Integer data;
    public  Node next;
    public Node(Integer data){
        this.data = data;
    }


    public static Node head1 = new Node(null);
    public static Node head2 = new Node(null);
    static {
        Node node1 = head1;
        Node headNode1 = head1;
        Node node2 = head2;
        Node headNode2 = head2;
        for(int i=0; i < 10; i+=2){
            node1.next = new Node(i);
            node1 = node1.next;
            node2.next = new Node(i+1);
            node2 = node2.next;
        }
        System.out.print("linked list1 init :");
        while (headNode1.next != null){
            System.out.print(headNode1.next.data+"->");
            headNode1 = headNode1.next;
        }
        System.out.println("null");


        System.out.print("linked list2 init :");
        while (headNode2.next != null){
            System.out.print(headNode2.next.data+"->");
            headNode2 = headNode2.next;
        }
        System.out.println("null");
    }


    public void revied(){
        Node first = head1.next;
        if(first == null){
            System.out.println("linked list is empty");
            return;
        }
        if(first.next == null){
            System.out.println("result is : "+first.data);
            return;
        }
        Node secode = first.next == null ? null : first.next;
        head1 = secode.next;
        first.next = null;
        secode.next = first;
        while (head1 != null){
            first = secode;
            secode = head1;
            head1 = head1.next;
            secode.next = first;
        }
        head1 = new Node(null);
        head1.next = secode;
        printResult(head1);
    }


    public void pingjie(){
        Node s1 = head1.next;
        Node b1 = s1 == null ? null : s1.next;

        Node s2 = head2.next;
        Node b2 = s2 == null ? null : s2.next;

        if(s1 == null){
            printResult(head2);
            return;
        }
        if(s2 == null){
            printResult(head1);
            return;
        }

        while (b2 != null && b1 != null){
            if(s1.data < s2.data){
                while (b1.data < s1.data){
                    s1 = b1.next;
                    b1 = s1.next;
                }

                while (b2.data<b1.data){
                    b2 = b2.next;
                }

                s1.next = s2;
                s2.next = b1;

                s1 = b1.next;
                b1.next = b2;
                b1 = s1 == null ? null :s1.next;
                s2 = b2;
                b2 = b2.next;


            } else {
                Node temp = s1;
                s1 = s2;
                s2 = temp;


                temp = b1;
                b1 = b2;
                b2 = temp;
            }
        }

        printResult(head1);

    }

    public void pingjie2(){
        Node newhead = new Node(null);
        Node head = newhead;
        Node node1 = head1.next;
        Node node2 = head2.next;
        while (node1 != null && node2 != null){
            if(node1.data < node2.data){
                newhead.next = node1;
                newhead = node1;
                node1 = node1.next;
            }else{
                newhead.next = node2;
                newhead = node2;
                node2 = node2.next;
            }
        }

        if(node1 != null){
            newhead.next = node1;
        }else{
            newhead.next = node2;
        }

        printResult(head);


    }

    public void printResult(Node head){
        System.out.print("result is :");
        while (head.next != null){
            System.out.print(head.next.data+"->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        Node node = new Node(null);
       // node.revied();
        node.pingjie2();
    }



}
