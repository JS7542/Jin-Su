import java.io.*;
import java.util.*;

class Main {
    /*
     * 수열을 절반으로 나누어 각 절반의 모든 부분수열 합을 생성한다.
     * 한쪽 합을 정렬하고 다른 쪽 합마다 목표 보완값의 등장 횟수를 이분 탐색으로 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int middle = n / 2;
        long[] left = subsetSums(numbers, 0, middle);
        long[] right = subsetSums(numbers, middle, n);

        Arrays.sort(right);

        long answer = 0;

        for (long value : left) {
            long needed = target - value;
            answer += upperBound(right, needed) - lowerBound(right, needed);
        }

        if (target == 0) answer--;

        System.out.print(answer);
    }

    static long[] subsetSums(int[] numbers, int start, int end) {
        int length = end - start;
        long[] sums = new long[1 << length];

        for (int mask = 0; mask < sums.length; mask++) {
            long sum = 0;

            for (int bit = 0; bit < length; bit++) {
                if ((mask & (1 << bit)) != 0) sum += numbers[start + bit];
            }

            sums[mask] = sum;
        }

        return sums;
    }

    static int lowerBound(long[] values, long target) {
        int left = 0;
        int right = values.length;

        while (left < right) {
            int middle = (left + right) >>> 1;

            if (values[middle] < target) left = middle + 1;
            else right = middle;
        }

        return left;
    }

    static int upperBound(long[] values, long target) {
        int left = 0;
        int right = values.length;

        while (left < right) {
            int middle = (left + right) >>> 1;

            if (values[middle] <= target) left = middle + 1;
            else right = middle;
        }

        return left;
    }
}
