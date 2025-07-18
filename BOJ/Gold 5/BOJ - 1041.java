import java.io.*;
import java.util.*;

class Main {
    /*
     * 큰 정육면체에서 한 면·두 면·세 면이 보이는 작은 주사위 개수를 구한다.
     * 서로 마주보지 않는 면 조합의 최소 합을 계산해 각 개수와 곱한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[] faces = new long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());

        long total = 0;
        long maximum = 0;
        long oneFace = Long.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            faces[i] = Long.parseLong(st.nextToken());
            total += faces[i];
            maximum = Math.max(maximum, faces[i]);
            oneFace = Math.min(oneFace, faces[i]);
        }

        if (n == 1) {
            System.out.print(total - maximum);
            return;
        }

        long twoFaces = Long.MAX_VALUE;
        long threeFaces = Long.MAX_VALUE;

        for (int first = 0; first < 6; first++) {
            for (int second = first + 1; second < 6; second++) {
                if (first + second == 5) continue;

                twoFaces = Math.min(twoFaces, faces[first] + faces[second]);

                for (int third = second + 1; third < 6; third++) {
                    if (first + third == 5 || second + third == 5) continue;

                    threeFaces = Math.min(
                            threeFaces,
                            faces[first] + faces[second] + faces[third]
                    );
                }
            }
        }

        long countThree = 4;
        long countTwo = 8 * n - 12;
        long countOne = 5 * n * n - 16 * n + 12;

        long answer = countThree * threeFaces
                + countTwo * twoFaces
                + countOne * oneFace;

        System.out.print(answer);
    }
}
