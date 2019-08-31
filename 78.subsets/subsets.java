class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        solution.add(new ArrayList<>());
        for (int n : nums) {
            int size = solution.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(solution.get(i));
                subset.add(n);
                solution.add(subset);
            }
        }
        return solution;
    }
}