import java.io.*;

class Solution {
    static int n;
    static int answer;
    static boolean[] columns;
    static boolean[] diagonalDown;
    static boolean[] diagonalUp;

    /*
     * 각 행에 퀸을 하나씩 배치한다.
     * 열과 두 대각선 사용 여부를 확인하며 가능한 배치를 백트래킹한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            n = Integer.parseInt(br.readLine());
            answer = 0;
            columns = new boolean[n];
            diagonalDown = new boolean[n * 2];
            diagonalUp = new boolean[n * 2];

            place(0);
            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void place(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int down = row - col + n;
            int up = row + col;

            if (columns[col] || diagonalDown[down] || diagonalUp[up]) continue;

            columns[col] = true;
            diagonalDown[down] = true;
            diagonalUp[up] = true;

            place(row + 1);

            columns[col] = false;
            diagonalDown[down] = false;
            diagonalUp[up] = false;
        }
    }
}
