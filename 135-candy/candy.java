class Solution {
    public int candy(int[] r) {
        int n = r.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); 
        for (int i = 1; i < n; i++)
            if (r[i] > r[i-1])
                candies[i] = candies[i-1] + 1;
        for (int i = n-2; i >= 0; i--)
            if (r[i] > r[i+1])
                candies[i] = Math.max(candies[i], candies[i+1] + 1);

        int sum = 0;
        for (int c : candies) sum += c;
        return sum;
    }
}