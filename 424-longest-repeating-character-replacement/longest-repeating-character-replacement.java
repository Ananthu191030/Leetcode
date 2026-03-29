class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int freq[]=new int[26];
        int maxf = 0,l=0;
        int maxl = 0;
        for(int r=0;r<n;r++){
            freq[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,freq[s.charAt(r)-'A']);
            while((r-l+1)-maxf>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxl=Math.max(maxl,r-l+1);
        }
            return maxl;
    }
}