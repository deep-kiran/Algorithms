class Solution {
    PriorityQueue<Integer> minheap =new PriorityQueue<>();
    PriorityQueue<Integer> maxheap =new PriorityQueue<>(Collections.reverseOrder());
    public double[] medianSlidingWindow(int[] nums, int k) {
        int end =nums.length -k+1;
        if(end<0)return new double[0];
        double ans[] =new double[end];
        for(int i=0;i<=nums.length;i++){
            if(i>=k){
                ans[i-k]=getMedian();
                remove(nums[i-k]);
            }
            if(i<nums.length){
                add(nums[i]);
            }
        }
        return ans;
    }
    public void add(int i){
        if(i<getMedian()){
            maxheap.offer(i);
        }else{
            minheap.offer(i);
        }
        if(maxheap.size()>minheap.size()){
            minheap.offer(maxheap.poll());
        }else if(minheap.size()-maxheap.size()>1){
            maxheap.offer(minheap.poll());
        }
    }
    public void remove(int i){
        if(i<getMedian()){
            maxheap.remove(i);
        }else{
            minheap.remove(i);
        }
        if(maxheap.size()>minheap.size()){
            minheap.offer(maxheap.poll());
        }else if(minheap.size()-maxheap.size()>1){
            maxheap.offer(minheap.poll());
        }    }
    public double getMedian(){
        if(minheap.size()==0 && maxheap.size()==0)return 0;
        if(minheap.size()>maxheap.size())return (double)minheap.peek();
        else return ((double)minheap.peek()+ (double)maxheap.peek())/2.0;
    }
}
