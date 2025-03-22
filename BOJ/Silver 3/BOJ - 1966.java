import java.io.*;
import java.util.*;

class Main {
    /*
     * 문서 인덱스를 큐에 저장하고 현재보다 높은 우선순위가 남아 있는지 확인한다.
     * 높은 문서가 있으면 뒤로 보내고, 없으면 인쇄 순서를 증가시킨다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (tests-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] priorities = new int[n];
            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
                queue.offer(i);
            }

            int order = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                boolean higher = false;

                for (int index : queue) {
                    if (priorities[index] > priorities[current]) {
                        higher = true;
                        break;
                    }
                }

                if (higher) {
                    queue.offer(current);
                } else {
                    order++;

                    if (current == target) {
                        output.append(order).append('\n');
                        break;
                    }
                }
            }
        }

        System.out.print(output);
    }
}
