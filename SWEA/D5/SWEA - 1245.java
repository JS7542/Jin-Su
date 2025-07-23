import java.io.*;
import java.util.*;

class Solution {
    /*
     * 인접한 두 자성체 사이에는 힘이 평형을 이루는 점이 하나 존재한다.
     * 각 구간에서 좌우 힘의 차이를 기준으로 이분 탐색해 균형 위치를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            double[] position = new double[n];
            double[] mass = new double[n];

            for (int i = 0; i < n; i++) {
                position[i] = Double.parseDouble(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                mass[i] = Double.parseDouble(st.nextToken());
            }

            output.append('#').append(tc).append(' ');

            for (int gap = 0; gap < n - 1; gap++) {
                double left = position[gap];
                double right = position[gap + 1];

                for (int iteration = 0; iteration < 100; iteration++) {
                    double middle = (left + right) / 2.0;
                    double force = 0.0;

                    for (int i = 0; i < n; i++) {
                        double distance = middle - position[i];

                        if (distance < 0) {
                            force -= mass[i] / (distance * distance);
                        } else {
                            force += mass[i] / (distance * distance);
                        }
                    }

                    if (force > 0) left = middle;
                    else right = middle;
                }

                output.append(String.format(Locale.US, "%.10f", (left + right) / 2.0))
                        .append(' ');
            }

            output.append('\n');
        }

        System.out.print(output);
    }
}
