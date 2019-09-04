
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            getCombinationSum(target, i, solution, new ArrayList(), candidates);
        }
        return solution;
    }

    private void getCombinationSum(int target, int pos, List<List<Integer>> sol, List<Integer> currentList,
            int[] candidates) {
        target = target - candidates[pos];
        if (target < 0) {
            return;
        } else if (target == 0) {
            currentList.add(candidates[pos]);
            sol.add(new ArrayList<>(currentList));
            currentList.remove(currentList.size() - 1);
            return;
        } else {
            currentList.add(candidates[pos]);
            for (int i = pos; i < candidates.length; i++) {
                getCombinationSum(target, i, sol, currentList, candidates);
            }
            currentList.remove(currentList.size() - 1);
        }
    }
}