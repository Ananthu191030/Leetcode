class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length; // Size of the array 
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n]; // DP array
        Arrays.fill(dp, 1);

        // To store the length of longest string chain
        int maxLen = 0;

        // Computing the DP array 
        for (int i = 0; i < n; i++) {

            // For each previous index
            for (int j = 0; j < i; j++) {

                /* If the element at index i can be 
                included in the chain ending at index j */
                if (checkPossible(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; // Update the DP value
                }
            }

            // If a longer chain is found, update the values
            if (dp[i] > maxLen) maxLen = dp[i];
        }

        return maxLen;
    }

    // Function to check if the string can be added to the chain
    private boolean checkPossible(String s, String t) {
        // Base case
        if (s.length() != t.length() + 1) return false;

        int i = 0, j = 0; // Pointers

        // Traverse until the first string is exhausted
        while (i < s.length()) {

            // Move both pointers if characters matches
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            // Otherwise 
            else {
                i++;
            }
        }

        // Return true if both the string gets exhausted
        return (i == s.length() && j == t.length());
    }
}
