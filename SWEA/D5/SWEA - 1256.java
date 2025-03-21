import java.io.*;
import java.util.*;

class Solution {
    /*
     * 문자열의 모든 접미어를 생성해 사전순으로 정렬한다.
     * K번째 접미어가 존재하면 출력하고 범위를 벗어나면 none을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            int k = Integer.parseInt(br.readLine());
            String text = br.readLine();

            String[] suffixes = new String[text.length()];

            for (int index = 0; index < text.length(); index++) {
                suffixes[index] = text.substring(index);
            }

            Arrays.sort(suffixes);

            output.append('#').append(tc).append(' ');

            if (k > suffixes.length) output.append("none");
            else output.append(suffixes[k - 1]);

            output.append('\n');
        }

        System.out.print(output);
    }
}
