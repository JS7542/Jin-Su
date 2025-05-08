import java.io.*;
import java.util.*;

class Solution {
    /*
     * 외계 숫자 문자열을 0부터 9까지의 인덱스로 변환해 빈도를 센다.
     * 숫자 순서대로 원래 문자열을 빈도만큼 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        String[] names = {
            "ZRO", "ONE", "TWO", "THR", "FOR",
            "FIV", "SIX", "SVN", "EGT", "NIN"
        };

        Map<String, Integer> index = new HashMap<>();

        for (int value = 0; value < names.length; value++) {
            index.put(names[value], value);
        }

        StringBuilder output = new StringBuilder();

        for (int tc = 0; tc < tests; tc++) {
            StringTokenizer header = new StringTokenizer(br.readLine());
            String caseName = header.nextToken();
            int count = Integer.parseInt(header.nextToken());

            int[] frequency = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count; i++) {
                frequency[index.get(st.nextToken())]++;
            }

            output.append(caseName).append('\n');

            for (int value = 0; value < 10; value++) {
                for (int repeat = 0; repeat < frequency[value]; repeat++) {
                    output.append(names[value]).append(' ');
                }
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
