package tree.searchTree;
/**
 * Created by DELL on 2018/11/21.
 */

/**
 * user is lwb
 **/


public class SearchTree {

    static class SearchTreeNode {
        int data;
        SearchTreeNode left;
        SearchTreeNode right;

        public SearchTreeNode(int data) {
            this.data = data;
        }
    }


    private static SearchTreeNode root = new SearchTreeNode(33);

    private void initSearchTree(int[] datas){
        for(int data : datas){
            insert(root,data);
        }
    }

    private void initSearchTree_(int[] datas){
        for(int data : datas){
            insert_(root,data);
        }
    }

    private void insert(SearchTreeNode root,int data){
        if(root != null){
            if(data < root.data){
                if(root.left != null){
                    insert(root.left,data);
                }else{
                    root.left = new SearchTreeNode(data);
                }
            }else{
                if(root.right != null){
                    insert(root.right,data);
                }else{
                    root.right = new SearchTreeNode(data);
                }
            }
        }else{
            return;
        }
    }

    //将相同的节点插入到右子树中
    private void insert_ (SearchTreeNode node, int data){
        while (node != null){
            if(data < node.data){
                if(node.left != null){
                    node = node.left;
                } else {
                    node.left = new SearchTreeNode(data);
                    return;
                }
            } else {
                if(node.right != null){
                    node = node.right;
                }else{
                    node.right = new SearchTreeNode(data);
                    return;
                }
            }
        }
    }

    private void midel_visit(SearchTreeNode node){
        if(node != null){
            midel_visit(node.left);
            System.out.print(node.data+"  ");
            midel_visit(node.right);
        }
    }


    private void find(SearchTreeNode root,int data){
        if(root != null){
            if(root.data == data){
                System.out.println(data);
                return;
            }else if (data < root.data){
                System.out.print(root.data+"->");
                find(root.left,data);
            }else{
                System.out.print(root.data+"->");
                find(root.right,data);
            }
        }
    }

    private void find_(SearchTreeNode root,int data){
        while (root != null){
            if(root.data == data){
                System.out.println(data);
                return;
            }else if(data < root.data){
                System.out.print(root.data+"->");
                root = root.left;
            }else {
                System.out.print(root.data+"->");
                root = root.right;
            }
        }
    }

    SearchTreeNode parent = null;
    //因为用左子树的最右边的子节点替换要删除的节点的数据和用右子树的最左边节点替换要删除节点的数据是一样的。然后删除那个最左/最后节点即可，此时最左和最右节点，只有左或右子树或这个节点是叶子结点。
    //不需要
    private void delete(SearchTreeNode root,int data){
        if(root != null){
            if(root.data == data){
                SearchTreeNode newRoot = root;
                if(newRoot.left != null){
                    parent = newRoot;
                    newRoot = newRoot.left;
                    while (newRoot.right != null){
                        parent = newRoot;
                        newRoot = parent.right;
                    }
                    if(parent.right == newRoot) {
                        parent.right = newRoot.left;
                    }
                    else{
                        parent.left = newRoot.left;
                    }
                    root.data = newRoot.data;
                    return;
                }else if(newRoot.right != null){//和上面的判断执行的逻辑作用是重复的。
                    parent = newRoot;
                    newRoot = newRoot.right;
                    while (newRoot.left != null){
                        parent = newRoot;
                        newRoot = parent.left;
                    }
                    if(parent.right == newRoot) {
                        parent.right = newRoot.right;
                    }
                    else {
                        parent.left = newRoot.right;
                    }
                    root.data = newRoot.data;
                    return;
                }else{
                    if(parent != null){
                        if(parent.left == root) parent.left = null;
                        else parent.right = null;
                    }else{
                       // root = null;
                        return;
                    }
                }
            }else if(data < root.data){
                parent = root;
                delete(root.left,data);
            }else{
                parent = root;
                delete(root.right,data);
            }
        }
    }

    private void delete1(SearchTreeNode root,int data){
        if(root != null){
            if(data == root.data){
                //root：“删掉”
                SearchTreeNode newRoot = root;
                if(newRoot.left != null && newRoot.right != null){
                    //取出左子树中的最大值或者右子树中的最小值
                    parent = newRoot;
                    newRoot = newRoot.left;
                    while (newRoot.right != null){
                        parent = newRoot;
                        newRoot = newRoot.right;
                    }
                    root.data = newRoot.data;
                }

                SearchTreeNode deletingNode = null;
                if(newRoot.left != null){
                    deletingNode = newRoot.left;
                }else if(newRoot.right != null){
                    deletingNode = newRoot.right;
                }else{
                    deletingNode = null;
                }

                if(parent == null){
                    SearchTree.root = deletingNode;
                }else if(parent.right == newRoot){
                    parent.right = deletingNode;
                }else{
                    parent.left = deletingNode;
                }
            }else if(data < root.data){
                parent = root;
                delete1(root.left,data);
            }else{
                parent = root;
                delete1(root.right,data);
            }
        }
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        int[] datas = new int[]{17,50,13,18,34,58,16,25,51,66,19,27};
       // tree.initSearchTree(datas);
        tree.initSearchTree_(datas);
        tree.midel_visit(root);
        System.out.println();

        //tree.find_(root,27); //tree.find(root,27);
        int[] newdatas = new int[]{25,51,66,19,17,50,13,18,34,58,16,27};
        for (int data : newdatas){
            //tree.delete(root,data);
            tree.delete1(root,data);
            tree.midel_visit(root);
            System.out.println();
        }
    }
}
