package hashtable;
/**
 *
 * Created by DELL on 2018/11/8.
 *
 */

/**
 * user is lwb
 **/


public class LRUWithHashLiked {


    static class LRUNode{
        Integer key;
        String value;
        LRUNode pre;
        LRUNode next;
        LRUNode link;

        public LRUNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    LRUNode tail ;
    LRUNode header;

    int capcity = 5;
    int counter = 0;
    int cacheLength = 10;
    private LRUNode[] data = new LRUNode[capcity];

    int hash(int k){
        return k % capcity;
    }

    public LRUWithHashLiked() {
        for (int i = 0; i < capcity; i++) {
            data[i] = new LRUNode(null,null);
        }
        tail = new LRUNode(null,null);
        header = tail;
    }


    public void addNode(Integer k, String value){
        int index = hash(k);
        LRUNode currentHeader = data[index];
        LRUNode finded = null;
        while (currentHeader.link != null){
            if(currentHeader.link.key == k){
                //找到了，将其移动到双线链表最后
                finded = currentHeader.link;
                currentHeader.link.pre.next = currentHeader.link.next;
                currentHeader.link.next.pre = currentHeader.link.pre;
                break;
            }
            currentHeader = currentHeader.link;
        }

        if(finded == null){
            finded = new LRUNode(k,value);
            //添加到hash的拉链上。
            currentHeader.link = finded;
            if(counter + 1 > cacheLength){
                LRUNode deleted = header.next;
                header.next = header.next.next;
                header.next.pre = header;
                System.out.print("已满，删除头元素");
                int headerIndex = hash(deleted.key);
                LRUNode node = data[headerIndex];
                while (node.link != null){
                    if(node.link.key == deleted.key){
                        System.out.println("   同时删除hash的链表中的元素 key "+deleted.key+"后新增一个"+k);
                        node.link = node.link.link;
                        break;
                    }
                    node = node.link;
                }
            }else{
                counter ++;
                System.out.println("新增一个"+k);
            }
        }else{
            System.out.println("找到了。。");
        }
        //移动到双向链表的尾部
        tail.next = finded;
        finded.pre = tail;
        finded.next = null;
        tail = finded;
    }


    public Integer get(int key){

        int index = hash(key);
        LRUNode header = data[index];
        while (header.link != null){
            if(header.link.key == key){
                System.out.println("找到了key； "+key+"   value :"+ header.link.value);
                return key;
            }
            header = header.link;
        }
        System.out.println("没有找到 "+  key);
        return null;
    }



    public static void main(String[] args) {
        LRUWithHashLiked lru = new LRUWithHashLiked();
        for (int i = 0; i < 12; i++) {
            lru.addNode(i,""+i);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 12; i++) {
            lru.get(i);
        }
    }
}
