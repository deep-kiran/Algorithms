class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //int prev =lower -1;
        //very tricky the idea is to prevent overflow by changing everything to long
        long prev =(long)lower -1;
        List<String> ranges =new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            long end =(i==nums.length)? (long)upper+1:(long)nums[i];
            if(prev+2==end){
                ranges.add(String.valueOf(prev+1));
            }else if(prev+2 <end){
                ranges.add(String.valueOf(prev+1)+"->"+String.valueOf(end-1));
            }
            prev =end;
        }
        return ranges;
    }   
}
