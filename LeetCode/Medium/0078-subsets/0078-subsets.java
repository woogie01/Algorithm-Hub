class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(results, nums, 0, new ArrayDeque<>());
        return results;
    }

    public void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
        results.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(results, nums, i + 1, path);
            path.removeLast();
        }
    }
}