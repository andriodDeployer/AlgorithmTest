package tree.visittree;/**
 * Created by DELL on 2018/11/21.
 */

/**
 * user is lwb
 **/


public class LinkedStore {

    static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static TreeNode root = new TreeNode(0);
    private void init(){
        initTree(root);
    }

    private void initTree(TreeNode root){
       if(root.data < 5){
           root.left = new TreeNode(root.data * 2 + 1);
           root.right = new TreeNode(root.data * 2 + 2);
           initTree(root.left);
           initTree(root.right);
       }
       return;
    }


    private void before_visit(TreeNode root){
        if(root != null){
            System.out.print(root.data+"    ");
            before_visit(root.left);
            before_visit(root.right);
        }
    }

    private void midleVisit(TreeNode root){
        if(root != null){
            midleVisit(root.left);
            System.out.print(root.data+"    ");
            midleVisit(root.right);
        }
    }


    private void after_visit(TreeNode root){
        if(root != null){
            after_visit(root.left);
            after_visit(root.right);
            System.out.print(root.data+"    ");
        }
    }


    public static void main(String[] args) {
        LinkedStore store = new LinkedStore();
        store.init();
        store.before_visit(root);
        System.out.println();
        store.midleVisit(root);
        System.out.println();
        store.after_visit(root);

    }




}
