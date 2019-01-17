package thoughtofalgorithmic.greedy.distributecandy;/**
 * Created by DELL on 2019/1/14.
 */

import java.util.*;

/**
 * user is lwb
 **/


public class DistributeCandy {
    private static final int candyCount = 5;
    private static final int childCount = 10;
    private Candy[] candys;
    private Child[] children;

    private Map<Child,List<Candy>> maps = new HashMap<>();

    private void init(){
        candys = new Candy[candyCount];
        children = new Child[childCount];
        Random random = new Random();

        for (int i = 0; i < candyCount; i++) {
            candys[i] = new Candy("candy"+i,random.nextInt(15)+1);
        }
        for (int i = 0; i < childCount; i++) {
            children[i] = new Child("child"+i,random.nextInt(10)+1);
        }
    }


    private void distributecandy(){
        init();
        sortData();
        for (Child child : children){
            if(child.isUsed()){
                continue;
            }
            for (Candy candy : candys){
                if(!candy.isUsed() && candy.getProviderCount() >= child.getRequestCount()){
                    candy.setUsed(true);
                    child.setUsed(true);
                    List<Candy> lists = new ArrayList<>();
                    lists.add(candy);
                    maps.put(child,lists);
                    break;
                }
            }

            if(!child.isUsed()){
                int totleCount = 0;
                List<Candy> candies = new ArrayList<>();
                for(Candy candy : candys){
                    if(!candy.isUsed()){
                        totleCount += candy.getProviderCount();
                        candy.setUsed(true);
                        candies.add(candy);
                        if(totleCount>=child.getRequestCount()){
                            child.setUsed(true);
                            maps.put(child,candies);
                            break;
                        }
                    }
                }

                if(!child.isUsed()){
                    for (Candy candy : candies){
                        candy.setUsed(false);
                    }
                    printMap(maps);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        DistributeCandy distributeCandy = new DistributeCandy();
       // distributeCandy.init();
        //distributeCandy.sortData();
        distributeCandy.distributecandy();
    }


    private void printMap(Map<Child,List<Candy>> maps){
        for (Map.Entry<Child,List<Candy>> entry : maps.entrySet()){
            System.out.println(entry.getKey() + " : "+  entry.getValue());
        }

    }

    private void sortData(){
        Arrays.sort(children);
        Arrays.sort(candys);

        for (Child child : children){
            System.out.println(child);
        }

        for (Candy candy : candys){
            System.out.println(candy);
        }
    }







}
