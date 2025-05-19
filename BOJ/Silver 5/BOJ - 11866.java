import java.io.*;
import java.util.*;

class Main {
    /*
     * 1부터 N까지 사람을 큐에 넣는다.
     * K-1명은 뒤로 보내고 K번째 사람을 제거하는 과정을 반복한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int person = 1; person <= n; person++) queue.offer(person);

        StringBuilder output = new StringBuilder("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) queue.offer(queue.poll());

            output.append(queue.poll());
            if (!queue.isEmpty()) output.append(", ");
        }

        output.append('>');
        System.out.print(output);
    }
}
