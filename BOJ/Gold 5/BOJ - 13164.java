import java.io.*;
import java.util.*;

class Main {
    /*
     * 키를 정렬한 뒤 인접한 원생 사이의 키 차이를 계산한다.
     * K개 조로 나누려면 가장 큰 K-1개 경계를 끊고 나머지 차이만 더한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int groups = Integer.parseInt(st.nextToken());

        int[] heights = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(st.nextToken());

        int[] differences = new int[n - 1];

        for (int i = 0; i + 1 < n; i++) {
            differences[i] = heights[i + 1] - heights[i];
        }

        Arrays.sort(differences);

        int answer = 0;

        for (int i = 0; i < n - groups; i++) answer += differences[i];

        System.out.print(answer);
    }
}
