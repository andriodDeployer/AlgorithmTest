package stringpartten;/**
 * Created by DELL on 2018/12/18.
 */

import stringpartten.exception.LengthNoEqualException;

/**
 * user is lwb
 *  n:模式串的长度
 *  m:主串的长度。
 * 暴力匹配，判断主串的子串和模式串是否相同，需要比较n次，所以判断一次的时间复杂度为O(n),判断的次数为(m-n+1)次，
 * 所以总体的时间复杂度为O(mn)；
 *
 **/


public class BF {


    public static void main(String[] args) {
        char[] mainChars = {'a','b','c','d','e','m','f','g','h','i','j','k','l','m','n'};
        //char[] parttenChars = {'a','b','c'};
        //char[] parttenChars = {'b','c','d'};
        char[] parttenChars = {'l','n'};
        int begin = new BF().BFBegin(mainChars,parttenChars);
        System.out.println(begin);



    }

    private int BFBegin(char[] mainchars ,char[] partenchars){
        int m = mainchars.length;
        int n = partenchars.length;
        for (int i = 0; i <= m-n; i++) {//比较总次数为(m-n+1)
            //i表示主串中的子串在主串的起始位置。
            char [] targets = new char[n];
            for (int j = 0; j < n; j++) {
                targets[j] = mainchars[i + j];
            }
         if(isEqual(targets,partenchars))
             return i;
        }
        return -1;
    }


    private boolean isEqual(char[] targets, char[] sources){
        if(targets.length != sources.length){
            throw new LengthNoEqualException("targets length is not equal with sources length !!");
        }
        for (int i = 0; i < targets.length; i++) {
            if(targets[i] != sources[i])
                return false;
        }
        return true;
    }
}
