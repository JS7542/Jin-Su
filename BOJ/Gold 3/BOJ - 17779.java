import java.io.*;
import java.util.*;

class Main {
    /*
     * 기준점 x,y와 경계 길이 d1,d2의 모든 가능한 조합을 시도한다.
     * 경계를 표시해 다섯 선거구 인구를 나누고 최대·최소 차이의 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] population = new int[size + 1][size + 1];

        for (int row = 1; row <= size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int col = 1; col <= size; col++) {
                population[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                for (int d1 = 1; d1 <= size; d1++) {
                    for (int d2 = 1; d2 <= size; d2++) {
                        if (x + d1 + d2 > size) continue;
                        if (y - d1 < 1 || y + d2 > size) continue;

                        answer = Math.min(
                                answer,
                                difference(population, size, x, y, d1, d2)
                        );
                    }
                }
            }
        }

        System.out.print(answer);
    }

    static int difference(
            int[][] population,
            int size,
            int x,
            int y,
            int d1,
            int d2
    ) {
        int[][] district = new int[size + 1][size + 1];

        for (int index = 0; index <= d1; index++) {
            district[x + index][y - index] = 5;
            district[x + d2 + index][y + d2 - index] = 5;
        }

        for (int index = 0; index <= d2; index++) {
            district[x + index][y + index] = 5;
            district[x + d1 + index][y - d1 + index] = 5;
        }

        for (int row = x + 1; row < x + d1 + d2; row++) {
            boolean inside = false;

            for (int col = 1; col <= size; col++) {
                if (district[row][col] == 5) inside = !inside;
                else if (inside) district[row][col] = 5;
            }
        }

        int[] sum = new int[6];

        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (district[row][col] == 5) {
                    sum[5] += population[row][col];
                } else if (row < x + d1 && col <= y) {
                    sum[1] += population[row][col];
                } else if (row <= x + d2 && col > y) {
                    sum[2] += population[row][col];
                } else if (row >= x + d1 && col < y - d1 + d2) {
                    sum[3] += population[row][col];
                } else {
                    sum[4] += population[row][col];
                }
            }
        }

        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        for (int districtNumber = 1; districtNumber <= 5; districtNumber++) {
            minimum = Math.min(minimum, sum[districtNumber]);
            maximum = Math.max(maximum, sum[districtNumber]);
        }

        return maximum - minimum;
    }
}
