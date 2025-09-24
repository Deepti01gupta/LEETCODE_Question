class Solution {
    public int reverseBits(int n) {
        String bin=decimalToBinary(n);
        String reversed = new StringBuilder(bin).reverse().toString();
        return binaryToDecimal(reversed);
    }

    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append((num >>> i) & 1);
        }
        return sb.toString();
    }

    public static int binaryToDecimal(String binary) {
        long decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(binary.length() - 1 - i) == '1') {
                decimal += (1L << i);
            }
        }
        return (int) decimal;
    }
}