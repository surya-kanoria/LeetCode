class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (validate(A) || validate(B) || validate(C) || validate(D)) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                int count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                int c = map.getOrDefault((sum * -1), 0);
                count = count + c;
            }
        }
        return count;
    }

    private boolean validate(int[] test) {
        return test == null || test.length <= 0;
    }
}