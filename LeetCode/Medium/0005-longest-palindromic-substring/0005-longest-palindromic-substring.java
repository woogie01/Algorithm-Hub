class Solution {

    int start, maxLen;

    public String longestPalindrome(String str) {
        int len = str.length();
        if (len < 2) {
            return str;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(str, i, i + 1);
            extendPalindrome(str, i, i + 2);
        }
        return str.substring(start, start + maxLen);
    }

    public void extendPalindrome(String str, int j, int k) {
        while (j >= 0 && k < str.length() && str.charAt(j) == str.charAt(k)) {
            j--;
            k++;
        }
        
        if (maxLen < k - j - 1) { // (k - 1) - (j + 1) + 1 = k - j - 1
            start = j + 1;
            maxLen = k - j - 1;
        }
    }
}