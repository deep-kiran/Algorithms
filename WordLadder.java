class Pair{
    String s;
    Integer i;
    public Pair(String s, Integer i){
        this.s =s;
        this.i =i;
    }
}

class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l =beginWord.length();
        HashMap<String, ArrayList<String>> allstatelist =new HashMap<String, ArrayList<String>>();
        
        wordList.forEach(word-> {
            for(int i=0;i<l;i++){
                String genericstate =word.substring(0,i)+"*"+word.substring(i+1);
                ArrayList<String> parentmap = allstatelist.getOrDefault(genericstate,new ArrayList<>());
                parentmap.add(word);
                allstatelist.put(genericstate,parentmap);
            }
        });
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        HashMap<String, Boolean> visited =new HashMap<String, Boolean>();
        visited.put(beginWord,true);
        while(!q.isEmpty()){
            Pair node = q.poll();
            String word =node.s;
            int level =node.i;
            for(int i=0;i<l;i++){
                String genstate= word.substring(0,i)+"*"+word.substring(i+1);
                // if(!allstatelist.containsKey(genstate))continue;
                for(String adjword : allstatelist.getOrDefault(genstate,new ArrayList<String>())){
                    if(adjword.equals(endWord))
                        return level+1;
                    if(!visited.containsKey(adjword)){
                        visited.put(adjword,true);
                        q.add(new Pair(adjword,level+1));
                    }
                }
            }
        }
        return 0;
    }
}
