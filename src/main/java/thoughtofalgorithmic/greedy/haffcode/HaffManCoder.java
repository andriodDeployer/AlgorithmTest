package thoughtofalgorithmic.greedy.haffcode;/**
 * Created by DELL on 2019/1/15.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * user is lwb
 *
 * 哈夫曼编码：
 *  是压缩算法的一种，主要就是用简单占用空间少的字符来表示一个占用空间大的字符，就是一个简单记号来代替被压缩内容中的字符，从而降低文本总的空间占用。
 *  如对于一段文本：abcd，每个字符占用8位，那么这端文本总共占用32位空间。如果使用一个简单的记号进行代替的话，如a->1,b->01,c->001,d->0001，那么总的占用空间就是10位。
 *  HaffMan编码就是确定每个字符对应的记号/编码是什么，采用贪心的思想，同一个字符数量大的，使用相对短的编码，字符数量大的，使用相对长的编码。从而达到编码后总的长度最短。
 *
 *
 *
 **/


public class HaffManCoder {

    static class HaffCodeerNode{
        private HaffCodeerNode left;
        private HaffCodeerNode right;
        private HaffElement element;
        public HaffCodeerNode(HaffCodeerNode left, HaffCodeerNode right, HaffElement element) {
            this.left = left;
            this.right = right;
            this.element = element;
        }
    }

    public static void main(String[] args) {
        HaffManCoder coder = new HaffManCoder();
        HaffElement[] elements = coder.initAndSort();
//        System.out.println(coder.elements[0].getCount());
        HaffCodeerNode haffCode = coder.createHaffCode(elements);
        Map<HaffElement, String> coding = coder.coding(haffCode);
        coder.printHaffCode(coding);


    }

    private HaffElement[]  initAndSort(){
        HaffElement[] elements = new HaffElement[]{
                new HaffElement('a',450),
                new HaffElement('b',350),
                new HaffElement('c',90),
                new HaffElement('d',60),
                new HaffElement('e',30),
                new HaffElement('f',20)
            };
        Arrays.sort(elements);
        return elements;
    }


    private HaffCodeerNode createHaffCode(HaffElement[] elements){
        int begin = 1;
        if(elements.length < 1){
            return null;
        }
        HaffCodeerNode head = new HaffCodeerNode(null,null,elements[0]);
        while (begin  < elements.length){
            HaffCodeerNode node = new HaffCodeerNode(null,null ,elements[begin]);
            head = new HaffCodeerNode(head,node,new HaffElement(' ',head.element.getCount() + node.element.getCount()));
            begin ++;
        }
        return head;
    }

    private Map<HaffElement,String> coding(HaffCodeerNode head){
        StringBuilder builder = new StringBuilder();
        Map<HaffElement,String> maps = new HashMap<>();
        while (head.left != null){
            maps.put(head.right.element,new String(builder.toString()+"1"));
            builder.append("0");
            head = head.left;
        }
        return maps;
    }


    private void printHaffCode(Map<HaffElement,String> data){
        for(Map.Entry<HaffElement,String> entry : data.entrySet()){
            System.out.println(entry.getKey().getContent()+" : "+entry.getValue());
        }
    }
}
