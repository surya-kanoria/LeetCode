import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        int temp = getSum(root, sumFrequency);
        int maxValue = -1;
        int maxKey = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumFrequency.entrySet()) {
            if (entry.getValue() > maxValue) {
                res = new ArrayList<>();
                res.add(entry.getKey());
                maxValue = entry.getValue();
            } else if (entry.getValue() == maxValue) {
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int getSum(TreeNode node, HashMap<Integer, Integer> sumFrequency) {
        if (node == null) {
            return 0;
        }
        int left = getSum(node.left, sumFrequency);
        int right = getSum(node.right, sumFrequency);
        int sum = left + right + node.val;
        sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        return sum;
    }
}