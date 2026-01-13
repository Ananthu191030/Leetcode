class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String s2=new StringBuilder(s).reverse().toString();
        int dp[][]=new int[n+1][n+1];
        return fun(n,s,s2,dp);
    }
    public int fun(int n,String s1,String s2,int dp[][]){
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=n;j++) dp[0][j]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

}