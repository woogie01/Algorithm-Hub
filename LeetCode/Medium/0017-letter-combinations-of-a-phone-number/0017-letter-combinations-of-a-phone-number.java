class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return List.of();

        String[] map = {
            "", "", 
            "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(digits, 0, map, sb, res);
        return res;
    }

    private void dfs(String digits, int idx, String[] map, StringBuilder sb, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];

        if (letters.isEmpty()) {
            dfs(digits, idx + 1, map, sb, res);
            return;
        }

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, idx + 1, map, sb, res);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }

}