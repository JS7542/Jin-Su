import java.io.*;
import java.util.*;

class Solution {
    /*
     * 인접 행렬을 최단 거리 행렬로 바꾸고 플로이드-워셜을 수행한다.
     * 각 사람에서 다른 모든 사람까지 거리 합 중 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int tests = scanner.nextInt();
        StringBuilder output = new StringBuilder();
        final int INF = 1_000_000;

        for (int tc = 1; tc <= tests; tc++) {
            int n = scanner.nextInt();
            int[][] distance = new int[n][n];

            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    int connected = scanner.nextInt();

                    if (from == to) distance[from][to] = 0;
                    else distance[from][to] = connected == 1 ? 1 : INF;
                }
            }

            for (int middle = 0; middle < n; middle++) {
                for (int from = 0; from < n; from++) {
                    for (int to = 0; to < n; to++) {
                        distance[from][to] = Math.min(
                                distance[from][to],
                                distance[from][middle] + distance[middle][to]
                        );
                    }
                }
            }

            int answer = Integer.MAX_VALUE;

            for (int from = 0; from < n; from++) {
                int sum = 0;

                for (int to = 0; to < n; to++) {
                    sum += distance[from][to];
                }

                answer = Math.min(answer, sum);
            }

            output.append('#').append(tc).append(' ')
                    .append(answer).append('\n');
        }

        System.out.print(output);
    }

    private static class FastScanner {
        private final InputStream input;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer;
        private int length;

        FastScanner(InputStream input) {
            this.input = input;
        }

        int nextInt() throws IOException {
            int character;

            do {
                character = read();
            } while (character <= ' ');

            int value = 0;

            while (character > ' ') {
                value = value * 10 + character - '0';
                character = read();
            }

            return value;
        }

        private int read() throws IOException {
            if (pointer >= length) {
                length = input.read(buffer);
                pointer = 0;

                if (length <= 0) return -1;
            }

            return buffer[pointer++];
        }
    }
}
