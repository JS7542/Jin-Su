import java.io.*;

class Solution {
    /*
     * 문자열 앞부분의 길이를 1부터 늘리며 같은 패턴이 반복되는지 확인한다.
     * 처음으로 전체 문자열과 일치하는 반복 길이를 정답으로 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine().trim();
            int answer = 1;

            for (int len = 1; len <= 10; len++) {
                boolean same = true;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != s.charAt(i % len)) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    answer = len;
                    break;
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
