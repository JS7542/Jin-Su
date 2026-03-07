import java.io.*;
import java.util.*;

class Main {
    static int[] selected;
    static int[] state;
    static int cycleStudents;

    /*
     * 각 학생이 선택한 한 명을 따라가는 함수 그래프를 DFS한다.
     * 현재 탐색 중인 정점을 다시 만나면 그 지점부터의 학생 수를 사이클 인원으로 센다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine());
            selected = new int[n + 1];
            state = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int student = 1; student <= n; student++) {
                selected[student] = Integer.parseInt(st.nextToken());
            }

            cycleStudents = 0;

            for (int student = 1; student <= n; student++) {
                if (state[student] == 0) search(student);
            }

            output.append(n - cycleStudents).append('\n');
        }

        System.out.print(output);
    }

    static void search(int student) {
        state[student] = 1;
        int next = selected[student];

        if (state[next] == 0) {
            search(next);
        } else if (state[next] == 1) {
            cycleStudents++;

            for (int current = selected[next]; current != next; current = selected[current]) {
                cycleStudents++;
            }
        }

        state[student] = 2;
    }
}
