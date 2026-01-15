import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    int n;
    int[] dp;

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
    }

    public int minValidStrings(String[] words, String target) {
        for (String w : words) insert(w);

        n = target.length();
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int idx = target.charAt(j) - 'a';
                if (node.children[idx] == null) break;

                node = node.children[idx];
                if (dp[j + 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}
