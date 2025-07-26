class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> used = new HashMap<>();
        int answer = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            int prevIndex = used.getOrDefault(ch, -1);
            if (left <= prevIndex) {
                left = prevIndex + 1;
            }
            used.put(ch, right);
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}