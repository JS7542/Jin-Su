import java.io.*;
import java.util.*;

class Solution {
    static char[] values;
    static int[] left;
    static int[] right;
    static StringBuilder traversal;

    /*
     * 노드 번호별 문자와 왼쪽·오른쪽 자식 번호를 저장한다.
     * 왼쪽 서브트리, 현재 노드, 오른쪽 서브트리 순으로 재귀 방문한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            values = new char[n + 1];
            left = new int[n + 1];
            right = new int[n + 1];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                values[node] = st.nextToken().charAt(0);

                if (st.hasMoreTokens()) left[node] = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right[node] = Integer.parseInt(st.nextToken());
            }

            traversal = new StringBuilder();
            inorder(1);

            output.append('#').append(tc).append(' ')
                    .append(traversal).append('\n');
        }

        System.out.print(output);
    }

    static void inorder(int node) {
        if (node == 0) return;

        inorder(left[node]);
        traversal.append(values[node]);
        inorder(right[node]);
    }
}
