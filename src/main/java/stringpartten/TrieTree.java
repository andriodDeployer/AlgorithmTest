package stringpartten;
/**
 * Created by DELL on 2018/12/24.
 *
 * trie树是一种多叉树，又称为“字典树”，它的作用像一个字典一样，主要用来提供字符串的查找。
 * 将字符串中的每个字符，作为树一个节点，当多个字符串有公共前缀时，那么公共前缀就是剩下节点的“跟”
 * 利用trie树进行查找，就是利用字符串之间的公共前缀，将重复的前缀合并在一起，可以节省一定的空间占用。
 *
 * 由于trie树是一个多叉树，所以每个节点都会存放指向下一个叉的节点引用，
 * 如果trie存放的字符是小写的英文字母的话，那么一个节点要存放的下一个节点的指针个数为26.那么一个节点的占用的空间大小为：26*8(64为操作系统)+1(数据是一个字节)。
 * 虽然对于trie树对于公共前缀可以共用节点，但是每个节点占用的空间也是很可观的，如果一个节点的分叉量少的话，那么他大小为26的数组，将都是null的。
 * 会产生很多的无效数据，相当浪费内存。尤其当字符串的字符集很大的时候，每个数组的大小就会很大。
 *
 *
 * 这种产生内存浪费的主要原因在于：每个节点在创建时，都要创建一个大小为字符集大小的数组，这个数组很占空间的(对象头+对其填充+类型大小*数组中元素个数)。
 * 虽然占用了内存，但是因为将所有数组都存放到数组中，如果数组组织的好，(26个英文字母按照顺序存在数组中，那么字母在数组中的索引就是字母的ascll码-‘a’的ascll码)
 * 所以从数组中找到这个字母就很快捷方便。这也是空间换时间的一种使用。
 *
 *
 * 但是这种空间换时间的做法，有点不值，空间浪费太严重了，为了提升查找效率完全可以使用其他方式，hash表/红黑树等，虽然这种方式，查询效率不及数组，但是也是很高效的，
 * 这两种做法可以避免存放无效数据。节省的空间很可观。
 *
 * 通常trie的变种，都是在构建trie节点时，存放下个字符的数据结构上做优化，优化的方向主要是：快速查找和减少空间占用。
 *
 *
 *
 *
 *
 *
 *
 *
 */

/**
 * user is lwb
 **/


public class TrieTree {

    private TrieNode root = new TrieNode('/');

    static class TrieNode{
        char data;
        private TrieNode[] nodes;
        boolean endCode = false;
        public TrieNode(char data) {
            this.data = data;
            nodes = new TrieNode[26];
        }


//        public TrieNode getTrieNode(char ch){
//            int index  = ch - 'a';
//            return nodes[index];
//        }



        public TrieNode getTrieNode(char ch){
            int index  = ch - 'a';
            return nodes[index];
        }


        public void addTrieNode(char ch){
            int index  = ch - 'a';
            nodes[index] = new TrieNode(ch);
        }
    }


    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.nodes[index] == null){
//                p.nodes[index] = new TrieNode(text[i]); //这种写法，如果TrieNode数据结构中，不使用数组的话，那么这个语句也要改，所以不要直接使用属性信息，要使用提供的get方法，真真切切的感觉到了
                p.getTrieNode(text[i]);
            }
            p = p.nodes[index];
        }
        p.endCode = true;
    }


    public void find(char[] text){
        TrieNode p = root;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < text.length; i++) {
            if(p.getTrieNode(text[i]) == null){
                return;
            }
            if(text[i] == p.getTrieNode(text[i]).data){
                buffer.append(text[i]);
                if(p.endCode){
                    System.out.println("没有找到合适匹配");
                }else{
                    p = p.getTrieNode(text[i]);
                }
            }
        }
        System.out.println(buffer.toString()+":");
        if(!p.endCode){
            recur_data(p,new StringBuffer());
        }
    }

    private void recur_data(TrieNode node,StringBuffer buffer){
        if(!node.endCode){
            for (TrieNode p : node.nodes){
                if(p!= null){
                    recur_data(p,new StringBuffer(buffer).append(p.data));
                }
            }
        }else{
            System.out.println(buffer.toString());
        }
    }














    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        char[][] texts = {{'h','e','l','l','o'},
                          {'h','i'},
                          {'s','a','y'},
                          {'s','o'}};


        for (int i = 0; i < texts.length; i++) {
            trieTree.insert(texts[i]);
        }


        char[][] finder = {{'h'},{'h','e'},{'s'}};

        for (int i = 0; i < finder.length; i++) {
            trieTree.find(finder[i]);
            System.out.println();
        }
    }




}
