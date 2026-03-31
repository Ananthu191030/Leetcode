class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int lsum=0,rsum=0,maxs=0;
       for(int i=0;i<k;i++){
        lsum+=cardPoints[i];
       }
       maxs=lsum;
       int rindex=n-1;
       for(int i=k-1;i>=0;i--){
        if(rindex>=0){
        lsum-=cardPoints[i];
        rsum+=cardPoints[rindex];
        rindex--;
        maxs=Math.max(maxs,lsum+rsum);
       }
       }
        return maxs;
    }
}