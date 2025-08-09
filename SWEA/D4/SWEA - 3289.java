import java.io.*;
import java.util.*;

class Solution {
    static int[] parent;

    /*
     * 합집합 명령은 두 원소의 루트를 하나로 연결한다.
     * 같은 집합 확인 명령은 두 루트가 같은지 비교해 1 또는 0을 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int commands = Integer.parseInt(st.nextToken());

            parent = new int[n + 1];

            for (int value = 1; value <= n; value++) parent[value] = value;

            output.append('#').append(tc).append(' ');

            for (int i = 0; i < commands; i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                if (type == 0) {
                    union(first, second);
                } else {
                    output.append(find(first) == find(second) ? 1 : 0);
                }
            }

            output.append('\n');
        }

        System.out.print(output);
    }

    static int find(int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent[value]);
    }

    static void union(int first, int second) {
        int firstRoot = find(first);
        int secondRoot = find(second);

        if (firstRoot != secondRoot) parent[secondRoot] = firstRoot;
    }
}
