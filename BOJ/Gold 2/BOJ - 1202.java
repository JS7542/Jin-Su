import java.io.*;
import java.util.*;

class Main {
    /*
     * 보석을 무게순, 가방을 용량순으로 정렬한다.
     * 각 가방에 들어갈 수 있는 보석을 최대 힙에 넣고 가장 비싼 보석을 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jewelsCount = Integer.parseInt(st.nextToken());
        int bagsCount = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[jewelsCount][2];

        for (int i = 0; i < jewelsCount; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[bagsCount];
        for (int i = 0; i < bagsCount; i++) bags[i] = Integer.parseInt(br.readLine());

        Arrays.sort(jewels, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(bags);

        PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int jewelIndex = 0;

        for (int capacity : bags) {
            while (jewelIndex < jewelsCount && jewels[jewelIndex][0] <= capacity) {
                values.offer(jewels[jewelIndex][1]);
                jewelIndex++;
            }

            if (!values.isEmpty()) answer += values.poll();
        }

        System.out.print(answer);
    }
}
