package hashtable;/**
 * Created by DELL on 2018/11/13.
 */

import java.util.*;

/**
 * user is lwb
 *
 * hash一致性简单实现。
 **/


public class HashConsistency {

    private int locationCount = 100;
    private int nodeCount = 3;
    private int virtualReplac = 2;
    private static Map<Integer,String> allData = new HashMap<Integer, String>();
    private Random locationRandom = new Random();

    public int getLocation(){
        return locationRandom.nextInt(100);
    }

    private Set<Integer> allBindLocatioin = new HashSet<Integer>();

    //存储节点信息
    public Map<Integer,StorageNode> storageNodes = new HashMap<Integer, StorageNode>();
    //地址和id
    public Map<Integer,Integer> location2Id = new HashMap<Integer, Integer>();
    //id和关联的地址
    private Map<Integer,List<Integer>> id2locations = new HashMap<Integer,List<Integer>>();

    private static String getValueFromAll(Integer key){
        System.out.println("from AllData: "+ key);
        return allData.get(key);
    }

    public HashConsistency() {
        init();
    }

    private void init(){
        for (int i = 0; i < 100; i++) {
            allData.put(i,""+i);
        }
        for (int i = 0; i < nodeCount; i++) {
            addNode();
        }
        System.out.println("disbuteed :"+location2Id);
    }

    //新增节点
    public void addNode(){
        StorageNode node = new StorageNode();
        int nodeId = node.id;
        for (int i = 0; i < virtualReplac; i++) {
            int location = getLocation();
            while (allBindLocatioin.contains(location)){
                location = getLocation();
            }
            allBindLocatioin.add(location);
            location2Id.put(location,nodeId);

            List<Integer> list = id2locations.get(nodeId);
            if(list == null){
                list = new ArrayList<Integer>();
                id2locations.put(nodeId, list);
            }
            list.add(location);
        }
        storageNodes.put(nodeId,node);
    }

    //查询数据
    public String getValue(int key){
        int hash = key % locationCount;
        int location = getStatifyNode(hash);
        int nodeId = location2Id.get(location);
        StorageNode node = storageNodes.get(nodeId);
        return nodeId+"++"+hash+"========"+node.getValue(key);
    }

    private int getStatifyNode(int location){
        while (true){
            if (allBindLocatioin.contains(location++ % locationCount)){
                return (--location % locationCount);
            }
        }
    }

    //删除节点
    public void remove(int nodeId){
        for(int location : id2locations.get(nodeId)){
            allBindLocatioin.remove(location);
            location2Id.remove(location);//无所谓，不影响工作，影响监控
        }
        storageNodes.remove(nodeId);//无所谓，不影响工作，影响监控
        id2locations.remove(nodeId);
    }


    static class StorageNode{
        private static int idSequencer = 0;
        int id = idSequencer++;
        private Map<Integer,String> data = new HashMap<Integer, String>();
        public String putData(Integer key,String value){
            data.put(key,value);
            return value;
        }

        public String getValue(Integer key){
            System.out.println("from "+id+": "+ key);
            String value =  data.get(key);
            if(value == null){
                String valueFromAll = getValueFromAll(key);
                value = putData(key,valueFromAll);
                System.out.println("there is no data ["+key+"] in node"+id+",and get data from all.");
            }
            return value;
        }
    }


    public static void main(String[] args) {
        HashConsistency consistency = new HashConsistency();
        consistency.init();
        consistency.getValue(1);
        consistency.getValue(1);
    }




}
