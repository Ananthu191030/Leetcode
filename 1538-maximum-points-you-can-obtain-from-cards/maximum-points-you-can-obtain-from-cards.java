class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0,sum=0,maxlen=0;
        for(int i=0;i<k;i++)
        {
            lsum+=cardPoints[i];
        }
        sum=lsum;
        int ind=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[ind];
            ind--;
            sum=Math.max(sum,lsum+rsum);
        }
        return sum;
        
    }
}