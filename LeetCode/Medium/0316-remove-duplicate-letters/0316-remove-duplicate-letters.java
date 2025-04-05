class Solution {
     public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            counter.put(ch, counter.get(ch) - 1);
            if (seen.get(ch) != null && seen.get(ch)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }
            
            stack.push(ch);
            seen.put(ch, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}