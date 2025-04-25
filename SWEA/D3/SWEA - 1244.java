import java.io.*;
import java.util.*;

class Solution {
    static char[] digits;
    static int exchanges;
    static int answer;
    static Set<String>[] visited;

    /*
     * 가능한 두 자리 교환을 깊이 우선으로 탐색한다.
     * 같은 교환 횟수에서 이미 본 숫자 배열은 건너뛰고 최대값을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            digits = st.nextToken().toCharArray();
            exchanges = Integer.parseInt(st.nextToken());
            answer = 0;

            visited = new HashSet[exchanges + 1];
            for (int i = 0; i <= exchanges; i++) visited[i] = new HashSet<>();

            search(0);
            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void search(int depth) {
        String state = new String(digits);

        if (!visited[depth].add(state)) return;

        if (depth == exchanges) {
            answer = Math.max(answer, Integer.parseInt(state));
            return;
        }

        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                swap(i, j);
                search(depth + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int first, int second) {
        char temp = digits[first];
        digits[first] = digits[second];
        digits[second] = temp;
    }
}
