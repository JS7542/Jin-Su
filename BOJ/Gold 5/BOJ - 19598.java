import java.io.*;
import java.util.*;

class Main {
    /*
     * 회의를 시작 시간순으로 정렬하고 사용 중인 회의실 종료 시간을 최소 힙에 저장한다.
     * 가장 빨리 끝난 회의가 새 회의 시작 전에 끝났으면 같은 방을 재사용한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            return compare != 0 ? compare : Integer.compare(a[1], b[1]);
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            if (!rooms.isEmpty() && rooms.peek() <= meeting[0]) {
                rooms.poll();
            }

            rooms.offer(meeting[1]);
        }

        System.out.print(rooms.size());
    }
}
