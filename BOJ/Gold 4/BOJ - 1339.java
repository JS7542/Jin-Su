import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 알파벳이 자릿값에 기여하는 가중치를 모두 합산한다.
     * 가중치가 큰 알파벳부터 9, 8, ... 숫자를 배정해 총합을 최대화한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] weight = new long[26];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            long place = 1;

            for (int index = word.length() - 1; index >= 0; index--) {
                weight[word.charAt(index) - 'A'] += place;
                place *= 10;
            }
        }

        Long[] sorted = new Long[26];

        for (int i = 0; i < 26; i++) sorted[i] = weight[i];

        Arrays.sort(sorted, Collections.reverseOrder());

        long answer = 0;
        int digit = 9;

        for (long value : sorted) {
            if (value == 0 || digit < 0) break;

            answer += value * digit;
            digit--;
        }

        System.out.print(answer);
    }
}
