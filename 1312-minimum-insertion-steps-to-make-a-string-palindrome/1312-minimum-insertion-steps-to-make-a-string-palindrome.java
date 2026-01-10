class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        String reverse="";
        int m=n;
        int dp[][]=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            reverse+=s.charAt(i);
        }

        return n-lcp(dp,s,reverse,n,m);
    }
    public int lcp(int dp[][],String s,String reverse,int i,int j){
        for(int n=0;n<=i;n++){
            dp[n][0]=0;
            dp[0][n]=0;
        }
        for(int n=1;n<=i;n++){
            for(int m=1;m<=i;m++){
                if(s.charAt(n-1)==reverse.charAt(m-1)){
                    dp[n][m]=1+dp[n-1][m-1];
                }
                else
                {
                    dp[n][m]=0+Math.max(dp[n-1][m],dp[n][m-1]);
                }

            }
        }
        return dp[i][j];
        
    }

}