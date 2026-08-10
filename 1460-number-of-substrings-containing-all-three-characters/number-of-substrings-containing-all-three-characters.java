class Solution {
    public int numberOfSubstrings(String s) {
        int l=0,r=0,len=s.length(),res=0;
        int freq[]=new int[3];
        while(r<len){
            freq[s.charAt(r)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                res+=len-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
}