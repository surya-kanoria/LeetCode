class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 0) {
            return new int[0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] people1, int[] people2) {
                return people1[1] != people2[1] ? people1[1] - people2[1] : people2[0] - people1[0];
            }
        });
        int[][] solution = new int[people.length][2];
        solution[0] = people[0];
        for (int i = 1; i < people.length; i++) {
            int count = 0;
            int j = 0;
            while ((j < i) && count < people[i][1]) {
                if (people[i][0] <= solution[j][0]) {
                    count++;
                }
                j++;
            }
            for (int k = i; k > j; k--) {
                solution[k] = solution[k - 1];
            }
            solution[j] = people[i];
        }
        return solution;
    }

}