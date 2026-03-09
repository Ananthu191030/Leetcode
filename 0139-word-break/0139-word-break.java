class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); 
        Boolean[] memo = new Boolean[s.length()]; 
        return fun(s, 0, dict, memo);
    }

    public boolean fun(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
             if (dict.contains(word) && fun(s, end, dict, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}