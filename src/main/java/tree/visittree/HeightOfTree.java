package tree.visittree;/**
 * Created by DELL on 2018/11/22.
 */

/**
 * user is lwb
 **/


public class HeightOfTree {


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



    private int getHeightOfTree(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        int heightOfLeft =0;
        int heightOfRight = 0;
        if(node.left != null && node.right != null){
            heightOfLeft = getHeightOfTree(node.left);
            heightOfRight = getHeightOfTree(node.right);
            return max(heightOfLeft, heightOfRight) + 1;
        }
        if(node.left == null){
            return getHeightOfTree(node.right) + 1;
        }
        else{
            return getHeightOfTree(node.left) + 1;
        }
    }


    private int getHeightOfTree_(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        int heightOfLeft =0;
        int heightOfRight = 0;
        heightOfLeft = getHeightOfTree(node.left);
        heightOfRight = getHeightOfTree(node.right);
        if(node.left != null && node.right != null){
            return max(heightOfLeft, heightOfRight) + 1;
        }
        if(node.left == null){
            return heightOfRight + 1;
        }
        else{
            return heightOfLeft + 1;
        }
    }



    private int max(int leftHeight, int rightHeight){
        if(leftHeight > rightHeight){
            return leftHeight;
        }
        return rightHeight;
    }

    public static void main(String[] args) {
        HeightOfTree heightOfTree = new HeightOfTree();
        heightOfTree.init();
        System.out.println(heightOfTree.getHeightOfTree_(root));
    }


}
