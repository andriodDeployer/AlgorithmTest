package tree.mirrorTree;/**
 * Created by DELL on 2018/11/23.
 */

/**
 * user is lwb
 **/


public class ReverseTree {

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
        if(root.data < 2){
            root.left = new TreeNode(root.data * 2 + 1);
            root.right = new TreeNode(root.data * 2 + 2);
            initTree(root.left);
            initTree(root.right);
        }
        return;
    }

    private void reverseTree(TreeNode node){
        if(node != null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            reverseTree(node.left);
            reverseTree(node.right);
        }
    }

    private void before_visit(TreeNode root){
        if(root != null){
            System.out.print(root.data+"    ");
            before_visit(root.left);
            before_visit(root.right);
        }
    }

    public static void main(String[] args) {
        ReverseTree reverseTree = new ReverseTree();
        reverseTree.init();
        reverseTree.before_visit(root);
        reverseTree.reverseTree(root);
        System.out.println();
        reverseTree.before_visit(root);
    }

}
