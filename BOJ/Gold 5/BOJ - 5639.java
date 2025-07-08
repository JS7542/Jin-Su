import java.io.*;
import java.util.*;

class Main {
    static int[] preorder;
    static int index;

    /*
     * 전위 순회 값을 순서대로 읽으며 허용되는 값 범위 안의 노드만 재귀 생성한다.
     * 왼쪽과 오른쪽 서브트리를 처리한 뒤 현재 값을 출력해 후위 순회를 만든다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> values = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            values.add(Integer.parseInt(line));
        }

        preorder = values.stream().mapToInt(Integer::intValue).toArray();
        StringBuilder output = new StringBuilder();
        build(Long.MIN_VALUE, Long.MAX_VALUE, output);

        System.out.print(output);
    }

    static void build(long minimum, long maximum, StringBuilder output) {
        if (index >= preorder.length) return;

        int value = preorder[index];

        if (value <= minimum || value >= maximum) return;

        index++;
        build(minimum, value, output);
        build(value, maximum, output);
        output.append(value).append('\n');
    }
}
