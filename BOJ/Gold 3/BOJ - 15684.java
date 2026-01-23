import java.io.*;
import java.util.*;

class Main {
    static int columns;
    static int rows;
    static boolean[][] ladder;
    static int answer = 4;

    /*
     * 추가 가능한 가로선 위치를 백트래킹으로 최대 세 개까지 선택한다.
     * 모든 세로선이 자기 번호로 도착하는지 검사해 필요한 최소 추가 개수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        columns = Integer.parseInt(st.nextToken());
        int existing = Integer.parseInt(st.nextToken());
        rows = Integer.parseInt(st.nextToken());

        ladder = new boolean[rows + 1][columns + 1];

        for (int i = 0; i < existing; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            ladder[row][col] = true;
        }

        search(1, 0);

        System.out.print(answer > 3 ? -1 : answer);
    }

    static void search(int startPosition, int added) {
        if (added >= answer || added > 3) return;

        if (valid()) {
            answer = added;
            return;
        }

        for (int position = startPosition; position <= rows * (columns - 1); position++) {
            int row = (position - 1) / (columns - 1) + 1;
            int col = (position - 1) % (columns - 1) + 1;

            if (ladder[row][col]) continue;
            if (col > 1 && ladder[row][col - 1]) continue;
            if (col < columns - 1 && ladder[row][col + 1]) continue;

            ladder[row][col] = true;
            search(position + 1, added + 1);
            ladder[row][col] = false;
        }
    }

    static boolean valid() {
        for (int start = 1; start <= columns; start++) {
            int current = start;

            for (int row = 1; row <= rows; row++) {
                if (current < columns && ladder[row][current]) current++;
                else if (current > 1 && ladder[row][current - 1]) current--;
            }

            if (current != start) return false;
        }

        return true;
    }
}
