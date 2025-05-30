import java.io.*;
import java.util.*;

class Main {
    /*
     * 양수와 음수 위치를 거리 기준 내림차순으로 분리한다.
     * 각 방향에서 M권씩 묶어 가장 먼 거리의 왕복 비용을 더하고 전체 최장 거리는 한 번만 이동한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int books = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int farthest = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < books; i++) {
            int position = Integer.parseInt(st.nextToken());
            farthest = Math.max(farthest, Math.abs(position));

            if (position > 0) positive.add(position);
            else negative.add(-position);
        }

        positive.sort(Collections.reverseOrder());
        negative.sort(Collections.reverseOrder());

        int answer = 0;

        for (int i = 0; i < positive.size(); i += capacity) {
            answer += positive.get(i) * 2;
        }

        for (int i = 0; i < negative.size(); i += capacity) {
            answer += negative.get(i) * 2;
        }

        System.out.print(answer - farthest);
    }
}
