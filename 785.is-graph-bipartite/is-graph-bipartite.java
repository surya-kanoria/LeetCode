import java.util.HashSet;

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> left = new HashSet();
        HashSet<Integer> right = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (right.contains(i)) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (right.contains(graph[i][j])) {
                        System.out.println(i + "," + graph[i][j]);
                        return false;
                    } else {
                        left.add(graph[i][j]);
                    }
                }
            } else if (left.contains(i)) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (left.contains(graph[i][j])) {
                        System.out.println(i + "," + graph[i][j]);
                        return false;
                    } else {
                        right.add(graph[i][j]);
                    }
                }
            } else {
                boolean isLeftFound = false;
                boolean isRightFound = false;
                for (int j = 0; j < graph[i].length; j++) {
                    if (right.contains(graph[i][j])) {
                        isRightFound = true;
                    }
                    if (left.contains(graph[i][j])) {
                        isLeftFound = true;
                    }
                }
                if (isLeftFound && isRightFound) {
                    System.out.println(i);
                    return false;
                } else if (isLeftFound) {
                    right.add(i);
                    for (int j = 0; j < graph[i].length; j++) {
                        if (right.contains(graph[i][j])) {
                            System.out.println(i + "," + graph[i][j]);
                            return false;
                        } else {
                            left.add(graph[i][j]);
                        }
                    }
                } else {
                    left.add(i);
                    for (int j = 0; j < graph[i].length; j++) {
                        if (left.contains(graph[i][j])) {
                            System.out.println(i + "," + graph[i][j]);
                            return false;
                        } else {
                            right.add(graph[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}