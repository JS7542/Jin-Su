import java.io.*;

class Main {
    /*
     * 마지막 레벨부터 앞쪽으로 이동하며 점수가 반드시 작아지도록 조정한다.
     * 앞 레벨 점수가 뒤 레벨 이상이면 뒤 점수보다 1 작게 낮춘다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) scores[i] = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] >= scores[i + 1]) {
                int adjusted = scores[i + 1] - 1;
                answer += scores[i] - adjusted;
                scores[i] = adjusted;
            }
        }

        System.out.print(answer);
    }
}
