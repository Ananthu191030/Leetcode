class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        List<int[]> merge=new ArrayList<>();
        for(int inter[]:intervals){
            if(merge.isEmpty() || merge.get(merge.size()-1)[1] < inter[0]){
             merge.add(new int[]{inter[0], inter[1]});}
             else{
                int last=merge.size()-1;
                merge.get(last)[1]=Math.max(merge.get(last)[1], inter[1]);
             }
        }
        return merge.toArray(new int[merge.size()][]);
    
    }
}