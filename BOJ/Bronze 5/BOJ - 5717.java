import java.io.*;
import java.util.*;

class Main {
    /*
     * 두 친구 수가 모두 0이 될 때까지 입력을 반복한다.
     * 각 줄의 두 값을 더해 전체 친구 수를 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == 0 && second == 0) break;

            sb.append(first + second).append('\n');
        }

        System.out.print(sb);
    }
}
