import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] == 0) {
                    list.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    if (j > 0) {
                        while (j < arr.length && arr[j] == arr[j - 1]) {
                            j++;
                        }
                    }
                    if (k < (arr.length - 1)) {
                        while (k > 0 && arr[k] == arr[k + 1]) {
                            k--;
                        }
                    }
                } else if (arr[i] + arr[j] + arr[k] < 0) {
                    j++;
                    if (j > 0) {
                        while (j < arr.length && arr[j] == arr[j - 1]) {
                            j++;
                        }
                    }
                } else {
                    k--;
                    if (k < (arr.length - 1)) {
                        while (k > 0 && arr[k] == arr[k + 1]) {
                            k--;
                        }
                    }
                }

            }
            while ((i < arr.length - 1) && arr[i] == arr[i + 1]) {
                i++;
            }
        }
        return list;
    }
}