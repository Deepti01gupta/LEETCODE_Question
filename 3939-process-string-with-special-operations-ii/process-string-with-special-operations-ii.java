class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] length = new long[n + 1];
        length[0] = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                length[i + 1] = length[i] + 1;
            } else if (ch == '*') {
                length[i + 1] = Math.max(0, length[i] - 1);
            } else if (ch == '#') {
                length[i + 1] = Math.min((long)1e15 + 1, length[i] * 2);
            } else if (ch == '%') {
                length[i + 1] = length[i];
            }
        }

        if (k >= length[n]) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (k == length[i]) return ch;
            } else if (ch == '*') {
                if (length[i] < length[i + 1]) k++;
            } else if (ch == '#') {
                if (k >= length[i]) {
                    k -= length[i];
                }
            } else if (ch == '%') {
                k = length[i] - 1 - k;
            }
        }

        return '.';
    }
}