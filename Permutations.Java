class Permutations {
    public void backtrack(List<List<Integer>> al, List<Integer> temp,int []nums){
        if(nums.length ==temp.size()){
            al.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i]))continue;
            temp.add(nums[i]);
            backtrack(al,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> al =new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(al,new ArrayList<>(),nums);    
        return al;
    }
    
}
