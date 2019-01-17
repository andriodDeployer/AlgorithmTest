package recursion;/**
 * Created by DELL on 2018/10/25.
 */

/**
 * user is lwb
 **/


public class Hannoi {


    private static String a = "A";
    private static String b = "B";
    private static String c = "C";


    private void hanoi(int n,String a,String b,String c){
        if(n == 1){
            move(a,c);
        }else{
            hanoi(n-1,a,c,b);
            move(a,c);
            hanoi(n-1,b,a,c);
        }
    }

    private void move(String a,String b){
        System.out.println(a+"->"+b);
    }



    public static void main(String[] args){
        Hannoi hannoi = new Hannoi();
        hannoi.hanoi(10,a,b,c);
    }

}
