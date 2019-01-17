package stringpartten;

/**
 * user is lwb
 *
 *
 *
 **/


public class BM {
    private static final int SIZE = 256;

    public static void main(String[] args) {
        BM bm = new BM();

        char[] mainChars = {'a','b','c','d','e','m','f','g','h','i','j','k','l','m','n'};
        char[] parttenChars = {'a','b','c'};
       // char[] parttenChars = {'b','c','d'};
        //char[] parttenChars = {'l','n'};
       // int begin = bm.huaizifu(mainChars,parttenChars);
        int begin = bm.huaizifuAndHouzhui(mainChars,parttenChars);
        System.out.println(begin);
    }

    private void generatedBC(char[] parttenChars, int[] bc){
        //bc存放了，主串里的字符集中，每个字符在模式串中的位置(索引)，如果该字符在模式串中不存在的话，设置为-1.
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < parttenChars.length; i++) {
            int ascii = (int)parttenChars[i];
            bc[ascii] = i;
        }
    }




    private int huaizifu(char[] mainChars, char[] parttenChar){
        int m = mainChars.length;
        int n = parttenChar.length;
        int[] bc = new int[SIZE];
        generatedBC(parttenChar,bc);
        int i = 0;
        while (i <= m -n){
            int j;
            for (j = n-1; j >= 0 ; j--) {
                if(parttenChar[j] != mainChars[i + j]) //坏字符为i+j  Si = j
                    break;
            }
            if(j < 0){
                return i;
            }
            int Xi = bc[(int)mainChars[i+j]];
            i += (j - Xi);
        }
        return -1;
    }


    /**
     * 后缀子串：是一个字符串的子串[i , m-1],从i到字符串的最后一个字符之间的子串。i的取值范围为0到m-2。m表示模式串的长度。
     * 前缀子串：是一个字符串的子串[0,i],从字符串的第一个字符开始到i之间的子串，i的取值范围为1到m-1。m表示模式串的长度。
     *
     * 后缀数组：判断模式串中是否还有和后缀子串相同的子串，如果有的话，将后缀子串的长度作为索引，和后缀子串相同的子串的首字符再模式串中的位置作为数组的值。(如果存在和后缀子串相同的子串有多个的话，使用最右边的那个)。
     * 前缀数组：用来判断是否存在长度为k的前缀子串和相同长度的后缀子串相同。如果存在的话，将数组中索引为k元素设置为true。否则为false；//前缀数组主要为了解决当模式串中不存在第二个后缀子串时的情形。
     *
     *
     * 好后缀规则其实是很复杂的，但是实现的代码并不复杂，主要原因在于数据结构设计的好，主要就是两个数组suffix和prefix这两个数组，这两个数组在真正比较之前，就通过预处理的方式，填充好了，
     * 可以理解成空间换时间一种应用，将需要在运行时计算的信息，提前计算好了，用的时候直接去。这两个数组中的信息可以理解成元数据信息。
     *
     *
     * @param parttenChars
     */
    private void generateGS(char[] parttenChars,int[] suffix, boolean[] prefix){
        int parttenLength = parttenChars.length;
       // suffix  = new int[parttenLength]; //后缀,索引表示parttenChars的后缀子串的长度，
       // prefix = new boolean[parttenLength];
        for (int i = 0; i < parttenLength; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < parttenLength -1; i++) {
            int j = i;
            int k = 0;//每次都从0开始，主要为了获取开始索引最大的第二个后缀子串。

            while (j>=0 && parttenChars[j] == parttenChars[parttenLength-1-k]){
                k++;
                suffix[k] =j;
                --j;
            }

            if(j == -1){//说明退出条件为j>=0不满足导致的，此时说明后缀和前缀是一样的。
                prefix[k] = true;
            }
        }
    }

    //j表示坏字符在模式串中索引
    private int move(int j,int m,int[] suffix,boolean[] prefix){
        int afterLength = m -1 -(j+1); //好后缀的长度。
        if(suffix[afterLength] != -1){ //还存在其他的后缀子串，
            return   j + 1 - suffix[afterLength];
        }else{
            for (int i = afterLength-1; i > 0; i--) { //从大往小遍历，目的是获得最长的前缀子串
                if(prefix[i]){
                    return m-1-i;
                }
            }
        }
        return m;
    }

//因为好后缀存在的时候一定会有坏字符的存在。所以先用坏字符计算移动的距离，然后再用好后缀计算移动的距离。选择一个最长的。



    private int huaizifuAndHouzhui(char[] mainChars, char[] parttenChar){
        int m = mainChars.length;
        int n = parttenChar.length;
        int[] bc = new int[SIZE];
        generatedBC(parttenChar,bc);

        int[] suffix = new int[n];
        boolean[] prefix = new boolean[n];
        generateGS(parttenChar,suffix,prefix);

        int i = 0;
        int hzf = 0;
        int hhz = 0;
        while (i <= m -n){
            int j;
            for (j = n-1; j >= 0 ; j--) {
                if(parttenChar[j] != mainChars[i + j]) //坏字符为i+j  Si = j
                    break;
            }
            if(j < 0){
                return i;
            }
            int Xi = bc[(int)mainChars[i+j]];
            hzf= (j - Xi);

            if(j<m-1){//存在好后缀
                hhz = move(j,n,suffix,prefix);
            }
            if(hzf>hhz)
                return hzf;
            else
                return hhz;
        }
        return -1;
    }



}
