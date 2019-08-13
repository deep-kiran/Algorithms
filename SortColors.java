class SortColors {
    public void sortColors(int[] nums) {
        int low =0;
        int mid =low;
        int tmp =0;
        int high =nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){ //maintaining left boundary
                tmp =nums[low];
                nums[low++]=nums[mid];
                nums[mid++]=tmp;
                
            }else if(nums[mid]==2){ //maintaining right boundary
                tmp =nums[mid];
                nums[mid]=nums[high];
                nums[high--]=tmp;
            }
            else mid++;
        }
    }
}
