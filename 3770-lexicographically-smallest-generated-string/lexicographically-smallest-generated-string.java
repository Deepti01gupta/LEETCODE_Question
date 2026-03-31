import java.util.*;

class Solution {
    public String generateString(String S, String t) {
        char[] s = S.toCharArray();
        int n = s.length;
        int m = t.length();

        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');

        // Step 1: Process 'T'
        for (int i = 0; i < n; i++) {
            if (s[i] == 'T') {
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != '?' && ans[i + j] != t.charAt(j)) {
                        return "";
                    }
                    ans[i + j] = t.charAt(j);
                }
            }
        }

        // Fill remaining '?' with 'a'
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
            }
        }

        // Step 2: Process 'F'
        for (int i = 0; i < n; i++) {
            if (s[i] == 'F') {

                // Check if substring equals t
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != t.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;

                    // Try to break it safely
                    for (int j = m - 1; j >= 0 && !changed; j--) {
                        int pos = i + j;
                        char original = ans[pos];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == t.charAt(j)) continue;

                            ans[pos] = c;

                            // Check all 'T' constraints again
                            boolean valid = true;
                            for (int k = 0; k < n && valid; k++) {
                                if (s[k] == 'T') {
                                    for (int x = 0; x < m; x++) {
                                        if (ans[k + x] != t.charAt(x)) {
                                            valid = false;
                                            break;
                                        }
                                    }
                                }
                            }

                            if (valid) {
                                changed = true;
                                break;
                            }
                        }

                        if (!changed) {
                            ans[pos] = original; // revert
                        }
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(ans);
    }
}