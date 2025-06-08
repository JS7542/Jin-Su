import java.io.*;
import java.util.*;

class Main {
    /*
     * 물이 새는 위치를 오름차순으로 정렬한다.
     * 아직 덮이지 않은 위치에서 새 테이프를 시작해 덮는 끝 위치를 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[] leaks = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) leaks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(leaks);

        int tapes = 0;
        int coveredUntil = Integer.MIN_VALUE;

        for (int leak : leaks) {
            if (leak > coveredUntil) {
                tapes++;
                coveredUntil = leak + length - 1;
            }
        }

        System.out.print(tapes);
    }
}
