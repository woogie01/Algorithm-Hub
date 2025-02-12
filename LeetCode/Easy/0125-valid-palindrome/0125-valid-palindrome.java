class Solution {
    public boolean isPalindrome(String s) {
        // 정규식 활용
        String filter = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(filter).reverse().toString();

        return filter.equals(reverse);
    }
}