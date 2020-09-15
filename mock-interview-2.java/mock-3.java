import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {

    static Integer[] solution(Integer[] N, int K) {
        int startMax = 0;
        for (int i = 0; i <= N.length - K; i++) {
            for (int j = 0; j < K; j++) {
                if (N[startMax + j] < N[i + j]) {
                    startMax = i;
                    break;
                } else if (N[startMax + j] == N[i + j]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        Integer[] res = new Integer[K];
        for (int i = 0; i < K; i++) {
            res[i] = new Integer(N[startMax + i]);
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
