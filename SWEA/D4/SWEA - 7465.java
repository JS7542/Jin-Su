import java.io.*;
import java.util.*;

class Solution {
    /*
     * 서로 알고 있는 두 사람을 유니온 파인드로 같은 집합에 합친다.
     * 모든 사람의 루트 개수를 세면 마을 무리의 수가 된다.
     */
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= tests; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int relations = Integer.parseInt(st.nextToken());

            parent = new int[people + 1];
            for (int person = 1; person <= people; person++) parent[person] = person;

            for (int i = 0; i < relations; i++) {
                st = new StringTokenizer(br.readLine());
                union(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }

            Set<Integer> groups = new HashSet<>();

            for (int person = 1; person <= people; person++) {
                groups.add(find(person));
            }

            output.append('#').append(tc).append(' ')
                    .append(groups.size()).append('\n');
        }

        System.out.print(output);
    }

    static int find(int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent[value]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }
}
