import java.io.*;
import java.util.*;

class Solution {
    /*
     * 각 문자와 반복 횟수를 입력받아 압축을 해제한 문자열을 만든다.
     * 출력할 때는 완성된 문자열을 10글자 단위로 나누어 줄바꿈한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            StringBuilder text = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int count = Integer.parseInt(st.nextToken());
                text.append(String.valueOf(ch).repeat(count));
            }

            out.append('#').append(tc).append('\n');
            for (int i = 0; i < text.length(); i += 10) {
                out.append(text, i, Math.min(i + 10, text.length())).append('\n');
            }
        }
        System.out.print(out);
    }
}
