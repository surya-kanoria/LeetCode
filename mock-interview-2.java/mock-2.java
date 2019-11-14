import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {

    static Integer[] solution(Integer[] N, int K) {
        int[] max = new int[K];
        for (int i = 0; i <= N.length - K; i++) {
            int[] temp = new int[K];
            for (int j = 0; j < K; j++) {
                temp[j] = N[i + j];
            }
            if (i == 0) {
                max = temp;
            } else {
                for (int j = 0; j < K; j++) {
                    if (temp[j] > max[j]) {
                        max = temp;
                        break;
                    } else if (temp[j] == max[j]) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
        Integer[] res = new Integer[K];
        for (int i = 0; i < K; i++) {
            res[i] = new Integer(max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] N = getIntegerArray(in.next());
        Integer K = Integer.parseInt(in.next());
        System.out.print(fromIntArray(solution(N, K)));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,")).map(Integer::valueOf).toArray(Integer[]::new);
    }

    private static String fromIntArray(Integer[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
            if (i < input.length - 1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }
}
