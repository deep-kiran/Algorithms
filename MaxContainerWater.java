class Solution {
    public int maxArea(int[] height) {
        int maxarea =0;
        int l =0;
        int r =height.length-1;
        while(l<r){
            maxarea =Math.max(maxarea,Math.min(height[l],height[r])*(r-l));                
                if(height[l]<height[r]){
                    l++;
                }else{
                    r--;
                }
        }
        return maxarea;
    }
    public int maxArea1(int[] height) {
        int maxarea =0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                maxarea = Math.max(maxarea, Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxarea;
    }
}
