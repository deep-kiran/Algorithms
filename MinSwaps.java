class MinSwaps {
    public int minSwaps(int[] data) {
        int noOnes =0;
        int n =data.length;
        for(int  i=0;i<n;i++){
            if(data[i]==1)
               noOnes++;
        }
        if(noOnes==0)return 0;
        int precomp[]=new int[n];
        if(data[0]==1){
            precomp[0]=1;
        }
        for(int i=1;i<n;i++){
            if(data[i]==1)
                precomp[i]=precomp[i-1]+1;
            else
                precomp[i]=precomp[i-1];
        }
        int x =noOnes;
        int maxOnes =Integer.MIN_VALUE;
        //sliding window of length x
        for(int i=x-1;i<n;i++){
            if(i==(x-1))
                noOnes =precomp[i];
            else{
                noOnes =precomp[i]- precomp[i-x];
            }
            maxOnes =Math.max(maxOnes,noOnes);
        }
        int noOfswaps =x -maxOnes;
        return noOfswaps;
    }
}
