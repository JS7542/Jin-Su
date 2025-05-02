import java.io.*;
import java.util.*;

class Main {
    static class Balloon {
        int index;
        int move;

        Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    /*
     * 덱의 앞 풍선을 터뜨린 뒤 이동값 방향에 맞춰 덱을 회전한다.
     * 양수는 앞으로, 음수는 뒤로 이동하며 터진 풍선 번호를 기록한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) deque.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));

        StringBuilder output = new StringBuilder();

        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();
            output.append(current.index).append(' ');

            if (deque.isEmpty()) break;

            if (current.move > 0) {
                for (int i = 1; i < current.move; i++) deque.offerLast(deque.pollFirst());
            } else {
                for (int i = 0; i < -current.move; i++) deque.offerFirst(deque.pollLast());
            }
        }

        System.out.print(output);
    }
}
