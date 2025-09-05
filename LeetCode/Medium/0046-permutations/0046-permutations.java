class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(results, new ArrayList<>(), input);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        if (elements.isEmpty()) {
            results.add(new ArrayList<>(prevElements));
            return;
        }

        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfs(results, prevElements, nextElements);
            prevElements.remove(e);
        }
    }
}