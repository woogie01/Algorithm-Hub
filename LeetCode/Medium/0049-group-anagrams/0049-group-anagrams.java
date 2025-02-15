class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> answer = new HashMap<>();
        for (String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String key = String.valueOf(chArr);

            if(!answer.containsKey(key)) {
                answer.put(key, new ArrayList<>());
            }
            answer.get(key).add(str);
        }
        return new ArrayList<>(answer.values());
    }
}