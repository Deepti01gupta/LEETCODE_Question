class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder sb = new StringBuilder();
        String ans = "";

        for (int i = 0; i < 3; i++) {
            sb.append(num.charAt(i));
        }
        if (isGood(sb.toString())) {
            ans = sb.toString();
        }

        for (int i = 3; i < num.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(num.charAt(i));

            String cur = sb.toString();
            if (isGood(cur) && (ans.isEmpty() || cur.compareTo(ans) > 0)) {
                ans = cur;
            }
        }
        return ans;
    }

    private boolean isGood(String s) {
        return s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2);
    }
}