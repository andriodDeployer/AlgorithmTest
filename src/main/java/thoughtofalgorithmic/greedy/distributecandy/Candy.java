package thoughtofalgorithmic.greedy.distributecandy;/**
 * Created by DELL on 2019/1/14.
 */

/**
 * user is lwb
 *
 * @author DELL*/


public class Candy implements Comparable<Candy>{

    private String name;
    private int providerCount;
    private boolean used;

    public Candy(String name, int providerCount) {
        this.name = name;
        this.providerCount = providerCount;
        used = false;
    }

    public String getName() {
        return name;
    }

    public int getProviderCount() {
        return providerCount;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public int compareTo(Candy o) {
        if(this.getProviderCount() > o.getProviderCount()){
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Candy{" +
                ", providerCount=" + providerCount +
                '}';
    }
}
