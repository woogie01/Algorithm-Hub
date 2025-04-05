class Solution {
      public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!table.containsKey(cur)) {
                stack.push(cur);
            } else if (stack.isEmpty() || table.get(cur) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}