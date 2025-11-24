import java.io.*;
import java.util.*;

class Main {
    /*
     * 지금까지 1부터 reachable까지 모든 무게를 만들 수 있다고 가정한다.
     * 다음 추의 무게가 reachable+1 이하이면 만들 수 있는 범위를 그만큼 확장한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) weights[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(weights);

        long reachable = 0;

        for (int weight : weights) {
            if (weight > reachable + 1) break;
            reachable += weight;
        }

        System.out.print(reachable + 1);
    }
}
