package search;

/**
 * Created by DELL on 2018/11/7.
 *
 * user is lwb
 *
 *
 *
 *
 *
 * 加上索引后的链表，称为跳表。因为加上索引之后，就像给我们的查找提供了线索一样，可以一次过滤掉很多无用的遍历，经过层层的索引
 * 我们快速的逼近要查找的数据，如果将这种查找方式映射到原来的链表上看的话，就像跳着遍历链表一样。所以叫做跳表。
 * 跳表的时间复杂度和二分查找是一样的，也是O(logn)，也就是说使用链表实现了二分查找，但是这这种做法：需要多个索引节点作为辅助才能实现，
 * 这也是空间换时间的一种体现。空间复杂度O(n).具体索引辅助节点有多少个，还要取决于索引建立的方式：
 *      如果每两个节点抽取一个的话，总的辅助索引节点个数为：n/2+n/4+n/8+...+4+2 = n-2;
 *      如果每三个节点抽取一个的话，总的辅助索引节点个数为：n/3+n/9+n/27+...+9+3= n/2;
 *  在实际开发过程中，链表中存放的可能都是比较大的对象，而辅助索引节点，存放的都是需要建立索引的(在每个字段上建立索引)关键值，相对与链表中存放的
 *  对象来说是很小的，所以，在使用链表是，没有必要在意空间复杂度。
 *
 *
 * 跳表在查找上的效率可以媲美二分查找，而且没有二分查找要求的连续的存储空间。由于基于跳表的查找效率，找到要插入/删除的点也是很快的O(logn)，
 * 因为基于链表的存储结构，所以可以进行高效的插入和删除。
 * 但是需要注意的是进行新增和删除，要维护索引。否则会影响查找效率,甚至出错：
 *          在不断新增节点的过程中，可能会使某两个索引之间的节点数据非常多，那么跳表就退化成了普通的链表。
 *          当删除的节点，存在于索引节点中时，在删除节点的同时还要删除索引。
 *
 *
 *
 *
 *
 *
 **/


public class JumpList {

    static class Node{
        Integer data;
        Node next;
        Node down;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Integer data){
            this.data = data;
        }

    }




    public static void main(String[] arg){
        Node dataHeader = new Node(null);
        Node current = dataHeader;
        for(int i=1; i<9; i++){
            current.next = new Node(i);
            current = current.next;
        }

        Node node = buildIndex(dataHeader, 8);


        for(int i=1;i<10;i++){
            System.out.println("查找:"+i);
            search(i,node);
            System.out.println();
            System.out.println();
            System.out.println();
        }





    }

    private static Node buildIndex(Node data, int length){
        int deep = (int)(Math.log((double) length)/Math.log((double)2))-1;
        Node[] indexs = new Node[deep];
        Node dataHeder = data;
        for(int i=deep-1;i>=0;i--){
            indexs[i] = new Node(null);
            Node currentHeader = indexs[i];
            if(i != deep-1){
                dataHeder = indexs[i+1];
            }
            Node next = dataHeder.next;

            currentHeader.next = new Node(next.data);
            currentHeader = currentHeader.next;
            currentHeader.down = next;

            while ((next = next.next)!=null && (next = next.next)!=null){
                currentHeader.next = new Node(next.data);
                currentHeader =  currentHeader.next;
                currentHeader.down = next;
            }
        }


//        for(Node node : indexs){
//            Node next = null;
//            while ((next =  node.next)!=null){
//                System.out.print(next.data+"   ->");
//                node = node.next;
//            }
//            System.out.println("null");
//        }

        return indexs[0];
    }


    private static void search(int value,Node firstIndex){
        firstIndex =  firstIndex.next;
        while (firstIndex != null){
            if(firstIndex.next != null && value<firstIndex.next.data){
                if(firstIndex.down != null){
                    firstIndex =  firstIndex.down;
                    System.out.println("向下");
                }else if(firstIndex.data == value) {
                    System.out.println("找到了"+firstIndex.data);
                    return;
                }else{
                    System.out.println("找不到");
                    return;
                }
            }else if(firstIndex.next != null && value>=firstIndex.next.data){
                firstIndex = firstIndex.next;
                System.out.print("向右");
            }else if(firstIndex.next == null){
                if(firstIndex.down != null){
                    firstIndex =  firstIndex.down;
                    System.out.println("向下");
                }else if(firstIndex.data == value) {
                    System.out.println("  找到了"+firstIndex.data);
                    return;
                }else{
                    System.out.println("找不到");
                    return;
                }


            }


        }




    }
}
