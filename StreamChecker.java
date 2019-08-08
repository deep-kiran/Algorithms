class Trie{
    Trie children[];
    boolean eow;
    public Trie(){
        this.children =new Trie[26];
        this.eow =false;
    }
}
class StreamChecker {
    Trie root;
    StringBuilder sb;
    public void buildTrie(String []words){
        root= new Trie();
        for(String s:words){
            Trie node =root;
            for(int i=s.length()-1;i>=0;i--){
                int c =s.charAt(i)-'a';
                if(node.children[c]==null){
                    node.children[c]=new Trie();
                }
                node =node.children[c];
            }
            node.eow=true;
        }
    }

    public StreamChecker(String[] words) {
        sb =new StringBuilder();
        buildTrie(words);
    }    
    public boolean query(char c) {
        sb.append(c);
        Trie p =root;
        for(int i=sb.length()-1;i>=0 && p!=null;i--){
            int d =sb.charAt(i)-'a';
            p =p.children[d];
            if(p!=null && p.eow ==true){
                return true;
            }
        }
        return false;     
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
