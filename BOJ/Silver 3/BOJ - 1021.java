import java.io.*;
import java.util.*;

class Main {
    /*
     * 목표 원소의 현재 위치를 찾아 왼쪽 회전과 오른쪽 회전 중 짧은 쪽을 선택한다.
     * 선택한 방향으로 덱을 회전한 뒤 앞 원소를 제거한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int value = 1; value <= n; value++) deque.offerLast(value);

        st = new StringTokenizer(br.readLine());
        int operations = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = 0;

            for (int value : deque) {
                if (value == target) break;
                index++;
            }

            if (index <= deque.size() / 2) {
                while (deque.peekFirst() != target) {
                    deque.offerLast(deque.pollFirst());
                    operations++;
                }
            } else {
                while (deque.peekFirst() != target) {
                    deque.offerFirst(deque.pollLast());
                    operations++;
                }
            }

            deque.pollFirst();
        }

        System.out.print(operations);
    }
}
