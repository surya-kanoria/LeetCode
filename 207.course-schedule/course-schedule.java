import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length <= 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                (map.get(prerequisites[i][0])).add(prerequisites[i][1]);
            } else {
                ArrayList<Integer> arrayList = new ArrayList();
                arrayList.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], arrayList);
            }
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int key : map.keySet()) {
            if (visited[key] == false) {
                if (getCanFinish(map, key, visited) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean getCanFinish(HashMap<Integer, List<Integer>> map, int key, boolean[] visited) {
        if (visited[key] == true) {
            return false;
        }
        visited[key] = true;
        if (map.containsKey(key)) {
            List<Integer> nodes = map.get(key);
            for (int node : nodes) {
                if (getCanFinish(map, node, visited) == false) {
                    return false;
                }
            }
        }
        visited[key] = false;
        return true;
    }
}