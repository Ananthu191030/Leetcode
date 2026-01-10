class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        int minimum=f(dp,n,m,word1,word2);
        return minimum;
    }
    public int f(int dp[][],int n,int m,String s1, String s2){
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else
                 dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        return dp[n][m];
        
    }
    // public int minDistance(String word1, String word2) {
    //     int n = word1.length();
    //     int m = word2.length();
    //     return f(n, m, word1, word2);
    // }

    // public int f(int n, int m, String s1, String s2) {
    //     if (n == 0) return m;
    //     if (m == 0) return n;
    //     if (s1.charAt(n - 1) == s2.charAt(m - 1))
    //         return f(n - 1, m - 1, s1, s2);
    //     return 1 + Math.min(
    //         f(n, m - 1, s1, s2), 
    //         Math.min(
    //             f(n - 1, m, s1, s2), 
    //             f(n - 1, m - 1, s1, s2) 
    //         )
    //     );
    // }
}