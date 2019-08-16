class Solution {
    public String longestPalindrome(String s) {
        if(s==""||s==null||s.length() ==0)return s;
        int l =s.length();
        int maxlen=0;
        int start=0;
        boolean dp[][] =new boolean[l][l];
        for(int i=0;i<l;i++){
            dp[i][i]=true;
            if(maxlen==0)maxlen=1;
            if(i<l-1&& s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start =i;
                maxlen=2;
            }
        }//base cases
        int j;
        //int start=0;
        for(int len =3;len<=l;len++){
            for(int i=0;i<l-len+1;i++){
                j =i+len-1;
                if(s.charAt(j)==s.charAt(i)&& dp[i+1][j-1]==true){
                    dp[i][j]=true;
                    if(len>maxlen){
                        start =i;
                        maxlen =len;
                    }
                }
            }
        }
        return s.substring(start,start+maxlen);
    }
}
