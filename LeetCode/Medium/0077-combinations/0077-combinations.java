class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(results, new LinkedList<>(), n, 1, k);
        return results;
    }

    private void dfs(List<List<Integer>> results, LinkedList<Integer> elements, int n, int start, int k) {
        if (k == 0) {
            results.add(new ArrayList<>(elements));
            return;
        }

        for (int i = start; i <= n; i++) {
            elements.add(i);
            dfs(results, elements, n, i + 1, k - 1);
            elements.removeLast();
        }
    }
}