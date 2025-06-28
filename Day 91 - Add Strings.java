class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l = num1.length() - 1;
        int r = num2.length() - 1;
        int carry = 0;

        while (l >= 0 || r >= 0 || carry != 0) {
            if (l >= 0) {
                carry += num1.charAt(l--) - '0';
            }
            if (r >= 0) {
                carry += num2.charAt(r--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }

        return sb.reverse().toString();
    }
}
