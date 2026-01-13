class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int dp[][]=new int[m+1][n+1];
        return fun(m,n,str1,str2,dp);
    }
    public String fun(int m,int n,String s1,String s2,int dp[][]){
        for(int i=0;i<=m;i++) dp[i][0]=0;
        for(int j=0;j<=n;j++) dp[0][j]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) 
                dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i=m,j=n;
        String ans="";
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans+=s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=s1.charAt(i-1);
                i--;
            }
            else{
                ans+=s2.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            ans+=s1.charAt(i-1);
            i--;
        }
        while(j>0){
            ans+=s2.charAt(j-1);
            j--;
        }
        String rev=new StringBuilder(ans).reverse().toString();
        return rev;
    }
}