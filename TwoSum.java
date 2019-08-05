class TwoSum {
    HashMap<Integer,Integer> mp;
    /** Initialize your data structure here. */
    public TwoSum() {
        mp =new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int c =mp.containsKey(number)? mp.get(number):0;
        mp.put(number,c+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int n = entry.getKey();
            int j=value -n;
            if(n==j){
                if(mp.get(n)>=2) return true;
            }
            else if(mp.containsKey(j)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
