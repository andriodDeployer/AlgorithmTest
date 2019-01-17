package thoughtofalgorithmic.greedy.haffcode;/**
 * Created by DELL on 2019/1/15.
 */

/**
 * user is lwb
 **/


public class HaffElement implements Comparable<HaffElement>{
    private char content;
    private int count;

    public HaffElement(char content, int count) {
        this.content = content;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public char getContent() {
        return content;
    }

    @Override
    public int compareTo(HaffElement o) {
        if(this.count > o.count){
            return 1;
        }else{
            return -1;
        }
    }
}
