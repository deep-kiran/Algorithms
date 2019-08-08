class FlippingGame {
    public boolean canWin(String s) {
        if(s==null|| s.length()<2)return false;
        HashMap<String, Boolean> mp =new HashMap<>();
        return canWin(s,mp);
    }
    public boolean canWin(String s, HashMap<String, Boolean> mp){
        if(mp.containsKey(s))return mp.get(s); //optimized by storing already seen strings and their results
        for(int i=0;i<s.length()-1;i++){
            if(s.startsWith("++",i)){
                String t = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(t,mp)){ //if opponent cant win
                    mp.put(s,true);
                    return true;
                }
            }
        }
        mp.put(s,false);
        return false;
    }
}
