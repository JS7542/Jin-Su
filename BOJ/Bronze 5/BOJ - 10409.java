import java.io.*;
import java.util.*;

class Main {
    /*
     * 작업 시간을 앞에서부터 누적하며 제한 시간 T를 넘는지 확인한다.
     * 제한 시간 안에 처리할 수 있는 작업의 개수를 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int elapsed = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            elapsed += Integer.parseInt(st.nextToken());
            if (elapsed > limit) break;
            answer++;
        }

        System.out.print(answer);
    }
}
