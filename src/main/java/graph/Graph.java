package graph;/**
 * Created by DELL on 2018/12/14.
 */

import java.util.LinkedList;

/**
 * user is lwb
 **/

//无向图
public class Graph {

    private int vCouont;//节点总个数
    LinkedList<Integer>[] datas ;//邻接表

    public Graph(int vCouont) {
        this.vCouont = vCouont;
        datas = new LinkedList[vCouont];
        for (int i = 0; i < vCouont; i++) {
            datas[i] = new LinkedList<Integer>();
        }
        init();
    }

    public int getvCouont() {
        return vCouont;
    }

    public void addEdge(int v1, int v2){
        datas[v1].add(v2);
        datas[v2].add(v1);
    }

    private void init(){
       /* addEdge(1,2);
        addEdge(1,3);
        addEdge(1,4);

        addEdge(4,2);
        addEdge(2,5);
        addEdge(4,3);
        addEdge(2,5);

        addEdge(4,5);*/



        addEdge(1,2);

        addEdge(2,3);
        addEdge(2,5);

        addEdge(3,4);

        addEdge(5,4);
        addEdge(5,6);

    }



}
