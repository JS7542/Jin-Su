import java.io.*;

class Main {
    /*
     * 왼쪽 위부터 두 행렬이 다른 위치를 만나면 그 위치에서 3×3 영역을 뒤집는다.
     * 모든 가능한 위치를 처리한 뒤 두 행렬이 같으면 횟수, 다르면 -1을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        char[][] first = new char[n][];
        char[][] second = new char[n][];

        for (int row = 0; row < n; row++) first[row] = br.readLine().toCharArray();
        for (int row = 0; row < n; row++) second[row] = br.readLine().toCharArray();

        int flips = 0;

        for (int row = 0; row + 2 < n; row++) {
            for (int col = 0; col + 2 < m; col++) {
                if (first[row][col] == second[row][col]) continue;

                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        first[r][c] = first[r][c] == '0' ? '1' : '0';
                    }
                }

                flips++;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (first[row][col] != second[row][col]) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        System.out.print(flips);
    }
}
