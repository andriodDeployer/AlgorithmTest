package tree.visittree;/**
 * Created by DELL on 2018/11/21.
 */

/**
 * user is wlb
 **/


public class LevelVisit {

    static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    static class LinkedNode {
        public TreeNode data;
        public LinkedNode next;

        public LinkedNode(TreeNode data) {
            this.data = data;
        }
    }

    private LinkedNode header = new LinkedNode(null);


    static TreeNode root = new TreeNode(0);
    private void init(){
        initTree(root);
    }

    private void initTree(TreeNode root){
        if(root.data < 2){
            root.left = new TreeNode(root.data * 2 + 1);
            root.right = new TreeNode(root.data * 2 + 2);
            initTree(root.left);
            initTree(root.right);
        }
        return;
    }



    private void levelVisit(){
        //构建队列的头尾指针
        LinkedNode current = header;
        LinkedNode tail = header;

        //root入队
        tail.next = new LinkedNode(root);
        tail = tail.next;
        tail.next = null;

        while (current.next != null){
            System.out.print(current.next.data.data+"   ");

            TreeNode node = current.next.data;
            if(node.left!=null){
                tail.next = new LinkedNode(node.left);
                tail = tail.next;

            }
            if(node.right != null){
                tail.next = new LinkedNode(node.right);
                tail = tail.next;
            }
            tail.next = null;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LevelVisit visit = new LevelVisit();
        visit.init();
        visit.levelVisit();
    }
}
