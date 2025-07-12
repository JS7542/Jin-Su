import java.io.*;
import java.util.*;

class Main {
    static char[][] children = new char[26][2];
    static StringBuilder output = new StringBuilder();

    /*
     * 각 알파벳 노드의 왼쪽과 오른쪽 자식을 저장한다.
     * 전위, 중위, 후위 순회를 재귀적으로 수행해 출력한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            children[parent - 'A'][0] = st.nextToken().charAt(0);
            children[parent - 'A'][1] = st.nextToken().charAt(0);
        }

        preorder('A');
        output.append('\n');
        inorder('A');
        output.append('\n');
        postorder('A');

        System.out.print(output);
    }

    static void preorder(char node) {
        if (node == '.') return;
        output.append(node);
        preorder(children[node - 'A'][0]);
        preorder(children[node - 'A'][1]);
    }

    static void inorder(char node) {
        if (node == '.') return;
        inorder(children[node - 'A'][0]);
        output.append(node);
        inorder(children[node - 'A'][1]);
    }

    static void postorder(char node) {
        if (node == '.') return;
        postorder(children[node - 'A'][0]);
        postorder(children[node - 'A'][1]);
        output.append(node);
    }
}
