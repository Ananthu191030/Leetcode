class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[10]; // digits 0-9
    }

    TrieNode root = new TrieNode();
    void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (node.children[d] == null)
                node.children[d] = new TrieNode();
            node = node.children[d];
        }
    }

    int match(String s) {
        TrieNode node = root;
        int len = 0;
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (node.children[d] == null) break;
            len++;
            node = node.children[d];
        }
        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (int num : arr1)
            insert(String.valueOf(num));
        int ans = 0;
        for (int num : arr2)
            ans = Math.max(ans, match(String.valueOf(num)));

        return ans;
    }
}