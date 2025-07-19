import java.io.*;
import java.util.*;

class Solution {
    /*
     * 직사각형의 네 변에서는 같은 길이가 두 번씩 등장한다.
     * 세 길이를 XOR하면 짝을 이루지 못한 네 번째 변의 길이만 남는다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken())
                    ^ Integer.parseInt(st.nextToken())
                    ^ Integer.parseInt(st.nextToken());

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }
}
