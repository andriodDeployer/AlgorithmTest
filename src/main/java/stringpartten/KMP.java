package stringpartten;
/**
 * Created by DELL on 2018/12/19.
 *
 *
 *  KMP真正比较的算法并不复杂，主要复杂的逻辑在于，每次移动多少位，和BM算法的设计一样，可以讲比较复杂的逻辑，采用预处理的方式，在计算之前讲这些元数据信息
 *  实现计算好，存放起来，在执行KMP算法时，直接从里面取出来。
 *
 *  KMP算法的主要复杂的地方在于构建next数组。也就是书数据信息。
 *  因为KMP算法和BM算法不同，他是从前往后比较的，所以会有好前缀的说法，就是主串和模式串相同的前缀到坏字符处结束。当遇到坏字符(模式串和主串不一样的字符)后，模式串如何移动？
 *  这个取决于好前缀的规则。
 *      计算处模式串中的好前缀的前缀子串和主串中好前缀的后缀子串最大的可匹配子串，那么模式串向前移动的距离为：模式串长度-好前缀的长度。换句话就是：让前文中最大可匹配子串的下一个字符和坏字符对齐(就是让两者进行比较)。
 *
 *
 */
public class KMP {


    public static void main(String[] args) {

    }



    private int kmp(char[] mainChars, char[] parttenChars){
        int mainLength = mainChars.length;
        int parttenLength = parttenChars.length;
        int[] nexts = getNexts();
        int j = 0;
        for (int i = 0; i < mainLength; i++) {
            if(j > 0 && mainChars[i] != parttenChars[j]){//如果模式串的第一个就是坏字符的话，不做处理
                j = nexts[j - 1]+1;
            }

            if(mainChars[i] == parttenChars[j]){
                j++;
            }

            if(j == parttenLength){
                return i - parttenLength +1;
            }
        }
        return -1;
    }



    private int[] getNexts(){

        return null;
    }



}
