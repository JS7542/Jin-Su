import java.io.*;
import java.util.*;

class Solution {
    /*
     * 일곱 숫자 중 서로 다른 세 숫자의 모든 조합 합을 집합에 저장한다.
     * 합을 내림차순으로 정렬해 다섯 번째 값을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int[] numbers = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 7; i++) numbers[i] = Integer.parseInt(st.nextToken());

            Set<Integer> sums = new HashSet<>();

            for (int first = 0; first < 5; first++) {
                for (int second = first + 1; second < 6; second++) {
                    for (int third = second + 1; third < 7; third++) {
                        sums.add(numbers[first] + numbers[second] + numbers[third]);
                    }
                }
            }

            List<Integer> sorted = new ArrayList<>(sums);
            sorted.sort(Collections.reverseOrder());

            output.append('#').append(tc).append(' ')
                    .append(sorted.get(4)).append('\n');
        }

        System.out.print(output);
    }
}
