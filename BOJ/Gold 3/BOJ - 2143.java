import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 배열의 모든 연속 부분합을 각각 생성한다.
     * 한쪽 부분합 빈도를 해시맵에 저장하고 다른 쪽에서 목표를 만드는 보완값 개수를 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());

        int firstLength = Integer.parseInt(br.readLine());
        int[] first = readArray(br, firstLength);

        int secondLength = Integer.parseInt(br.readLine());
        int[] second = readArray(br, secondLength);

        Map<Long, Long> firstSums = new HashMap<>();

        for (int start = 0; start < firstLength; start++) {
            long sum = 0;

            for (int end = start; end < firstLength; end++) {
                sum += first[end];
                firstSums.put(sum, firstSums.getOrDefault(sum, 0L) + 1);
            }
        }

        long answer = 0;

        for (int start = 0; start < secondLength; start++) {
            long sum = 0;

            for (int end = start; end < secondLength; end++) {
                sum += second[end];
                answer += firstSums.getOrDefault(target - sum, 0L);
            }
        }

        System.out.print(answer);
    }

    static int[] readArray(BufferedReader br, int length) throws Exception {
        int[] array = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < length; i++) array[i] = Integer.parseInt(st.nextToken());

        return array;
    }
}
