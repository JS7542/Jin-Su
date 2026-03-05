import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] children;
    static int removed;

    /*
     * 부모 배열로 자식 목록을 만들고 삭제할 노드의 서브트리는 탐색하지 않는다.
     * 남은 자식이 없는 노드를 리프로 세어 개수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        children = new ArrayList[n];

        for (int node = 0; node < n; node++) children[node] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;

        for (int node = 0; node < n; node++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) root = node;
            else children[parent].add(node);
        }

        removed = Integer.parseInt(br.readLine());

        System.out.print(root == removed ? 0 : countLeaves(root));
    }

    static int countLeaves(int node) {
        int activeChildren = 0;
        int leaves = 0;

        for (int child : children[node]) {
            if (child == removed) continue;

            activeChildren++;
            leaves += countLeaves(child);
        }

        return activeChildren == 0 ? 1 : leaves;
    }
}
