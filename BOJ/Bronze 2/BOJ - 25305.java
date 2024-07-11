import java.io.*;
import java.util.*;

class Main {
    /*
     * 응시자 점수를 오름차순으로 정렬한다.
     * 상위 K명의 마지막 점수는 정렬 배열의 N-K 위치에 있다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) scores[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(scores);
        System.out.print(scores[n - k]);
    }
}
