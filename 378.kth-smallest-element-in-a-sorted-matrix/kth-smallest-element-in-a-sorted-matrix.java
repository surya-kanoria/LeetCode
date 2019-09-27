class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int elements = matrix.length * matrix[0].length - k + 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                priorityQueue.offer(matrix[i][j]);
                if (priorityQueue.size() > elements) {

                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.peek();
    }
}