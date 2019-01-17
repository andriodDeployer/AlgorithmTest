package thoughtofalgorithmic.greedy.distributecandy;
/**
 * Created by DELL on 2019/1/14.
 */

/**
 * user is lwb
 *
 * @author DELL*/


public class Child implements Comparable<Child>{

    private String name;
    private int requestCount;
    private boolean used;

    public Child(String name, int requestCount) {
        this.name = name;
        this.requestCount = requestCount;
    }


    public int getRequestCount() {
        return requestCount;
    }

    @Override
    public int compareTo(Child o) {
        if(this.getRequestCount() > o.getRequestCount()){
            return 1;
        } else {
            return -1;
        }
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Child{" +
                ", requestCount=" + requestCount +
                '}';
    }
}
