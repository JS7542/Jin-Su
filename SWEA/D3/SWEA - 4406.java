import java.io.*;

class Solution {
    /*
     * 문자열을 순회하며 a, e, i, o, u를 제외한다.
     * 남은 자음만 원래 순서대로 결과에 이어 붙인다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            String word = br.readLine();
            StringBuilder filtered = new StringBuilder();

            for (char ch : word.toCharArray()) {
                if ("aeiou".indexOf(ch) < 0) filtered.append(ch);
            }

            output.append('#').append(tc).append(' ')
                    .append(filtered).append('\n');
        }

        System.out.print(output);
    }
}
