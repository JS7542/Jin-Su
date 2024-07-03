import java.io.*;
import java.util.*;

class Main {
    /*
     * 모든 점수의 합과 최댓값을 구한다.
     * 변환 점수의 평균은 sum * 100 / max / N으로 한 번에 계산한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double sum = 0;
        double max = 0;

        for (int i = 0; i < n; i++) {
            double score = Double.parseDouble(st.nextToken());
            sum += score;
            max = Math.max(max, score);
        }

        System.out.print(sum * 100.0 / max / n);
    }
}
