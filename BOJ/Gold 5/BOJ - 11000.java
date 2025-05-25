import java.io.*;
import java.util.*;

class Main {
    /*
     * 강의를 시작 시간 오름차순으로 정렬한다.
     * 가장 빨리 끝나는 강의실을 최소 힙으로 관리해 재사용 여부를 판단한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, Comparator.comparingInt(lecture -> lecture[0]));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (int[] lecture : lectures) {
            if (!endTimes.isEmpty() && endTimes.peek() <= lecture[0]) {
                endTimes.poll();
            }

            endTimes.offer(lecture[1]);
        }

        System.out.print(endTimes.size());
    }
}
