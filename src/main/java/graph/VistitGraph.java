package graph;/**
 * Created by DELL on 2018/12/14.
 */

/**
 * user is lwb
 **/


public class VistitGraph {

    private int[] visiting_Queue = new int[100];


    private void BFS_NonRecur(Graph graph,int begin, int end,Visiting stack){
        int[] visited = new int[graph.getvCouont()];
        int[] prev = new int[graph.getvCouont()];
        stack.addEle(begin);
        visited[begin] = 1;
        while (!stack.isFull()){
            int ele = stack.getEle();
            for (int data : graph.datas[ele]){
                if(visited[data] != 1){
                    prev[data] = ele;
                    if(data == end){
                        print(prev,begin,end);
                        return;
                    }
                    visited[data] = 1;
                    stack.addEle(data);
                }
            }
        }
    }


    private void BFS_Recur(Graph graph,int begin, int end,Visiting queue){
        int[] visited = new int[graph.getvCouont()];
        int[] prev = new int[graph.getvCouont()];
        queue.addEle(begin);
        visited[begin] = 1;
        BFS(graph,prev,visited,begin,end,queue);
    }


    private void BFS(Graph graph,int[] prev,int[] visited,int begin,int end,Visiting queue){
        if(queue.isFull()){
            return;
        }
        int ele = queue.getEle();
        for(int data : graph.datas[ele]){
            if(visited[data] != 1){
                prev[data] = ele;
                if(data == end){
                    print(prev,begin,end);
                    return;
                }
                visited[data] = 1;
                queue.addEle(data);
            }
        }
        BFS(graph,prev,visited,begin,end,queue);
    }




    private void DFS_NonRecur(Graph graph,int begin, int end ,Visiting stack){
        int[] prev = new int[graph.getvCouont()];
        int[] visited = new int[graph.getvCouont()];
        stack.addEle(begin);
        int parent = begin;
        while (!stack.isEmpty()){
            int ele = stack.getEle();
            visited[ele] = 1;
            prev[ele] = parent;
            if(ele == end){
                print(prev,begin,end);
                return;
            }
            boolean nochile = true;
            for(int data : graph.datas[ele]){
                if(visited[data] != 1){
                    nochile = false;
                    stack.addEle(data);
                    parent = ele;
                    break;
                }
            }
            if(nochile){
                stack.remove();
            }
        }
    }

    boolean isFound = false;
    private void DFS_Recur(int begin,int end,Graph graph){
        int[] visited = new int[graph.getvCouont()];
        int[] prev = new int[graph.getvCouont()];
        DFS(begin,end,graph,visited,prev);
        print(prev,begin,end);
    }
    private void DFS(int begin,int end,Graph graph,int[] visited,int prev[]){
        if(isFound){
            return;
        }

        visited[begin] = 1;
        if(begin == end){
            isFound = true;
            return;
        }

        for(int data : graph.datas[begin]){
            if(visited[data] != 1){
                prev[data] = begin;
                DFS(data,end,graph,visited,prev);
            }
        }


    }






    private void print(int prve[],int begin,int end){
        //0不能作为prve中的值
        if(prve[end] !=0 && begin != end){
            print(prve,begin,prve[end]);
        }
        System.out.print(end+"->");
    }





    public static void main(String[] args) {
        VistitGraph vistitGraph = new VistitGraph();
        Graph graph = new Graph(7);
//        vistitGraph.BFS_NonRecur(graph,3,5,Visiting.Queue.init());
//        System.out.println();
//        vistitGraph.BFS_Recur(graph,3,5,Visiting.Queue.init());

          vistitGraph.DFS_NonRecur(graph,1,6,Visiting.Stack);
          System.out.println();
          vistitGraph.DFS_Recur(1,6,graph);
    }







}
