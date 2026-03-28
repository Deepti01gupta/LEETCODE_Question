import java.util.*;

class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Validate diagonal
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }

        // Step 2: DSU (Union Find) to group equal indices
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Find function
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int x) {
                if (parent[x] != x) parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };

        // Union function
        java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
            int pa = find.applyAsInt(a);
            int pb = find.applyAsInt(b);
            if (pa != pb) parent[pb] = pa;
        };

        // Step 3: Build groups using LCP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union.accept(i, j);
                }
            }
        }

        // Step 4: Assign characters
        char[] word = new char[n];
        Arrays.fill(word, '#');

        char current = 'a';

        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = find.applyAsInt(i);
            if (!map.containsKey(p)) {
                if (current > 'z') return ""; // more than 26 groups
                map.put(p, current++);
            }
            word[i] = map.get(p);
        }

        // Step 5: Recompute LCP to validate
        int[][] check = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    if (i == n - 1 || j == n - 1)
                        check[i][j] = 1;
                    else
                        check[i][j] = 1 + check[i + 1][j + 1];
                } else {
                    check[i][j] = 0;
                }

                if (check[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}