import java.io.*;
import java.util.*;

class Main {
    /*
     * 각 테스트 케이스에서 반복 횟수와 문자열을 입력받는다.
     * 문자열의 각 문자를 지정된 횟수만큼 반복해 결과를 만든다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String text = st.nextToken();

            for (char ch : text.toCharArray()) {
                for (int i = 0; i < repeat; i++) out.append(ch);
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}
