package tree.visittree;
/**
 * Created by DELL on 2018/11/21.
 */

/**
 * user is lwb
 **/


public class Arraystore {

    private int[] dataStore = new int[5];

    static int rootIndex = 0;
    static int rootData = 0;


    private void init(int rootIndex,int rootData){
        initTree(rootIndex,rootData);
    }

    private void initTree(int index,int data){
        if(index < 5){
            dataStore[index] = data;
            initTree(index*2+1,data*2+1);
            initTree(index*2+2,data*2+2);
        }
    }

    private void before_visit(int rootIndex){
        if(rootIndex < 5){
            System.out.print(dataStore[rootIndex]+"   ");
            before_visit(rootIndex*2+1);
            before_visit(rootIndex*2+2);
        }
    }

    private void midel_visit(int rootIndex){
        if(rootIndex < 5){
            midel_visit(rootIndex*2+1);
            System.out.print(dataStore[rootIndex]+"   ");
            midel_visit(rootIndex*2+2);
        }
    }

    private void after_visist(int rootIndex){
        if(rootIndex < 5){
            after_visist(rootIndex*2+1);
            after_visist(rootIndex*2+2);
            System.out.print(dataStore[rootIndex]+"   ");
        }
    }


    private void printArray(){
        for (int i = 0; i < dataStore.length; i++) {
            System.out.print(dataStore[i]+"   ");
        }
    }

    public static void main(String[] args) {
        Arraystore arraystore = new Arraystore();
        arraystore.init(rootIndex,rootData);
        System.out.println();
        arraystore.before_visit(rootIndex);
        System.out.println();
        arraystore.midel_visit(rootIndex);
        System.out.println();
        arraystore.after_visist(rootIndex);
        System.out.println();
        arraystore.printArray();
    }


}
