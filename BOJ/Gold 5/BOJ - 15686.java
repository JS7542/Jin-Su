import java.io.*;
import java.util.*;

class Main {
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> stores = new ArrayList<>();
    static boolean[] selected;
    static int targetCount;
    static int answer = Integer.MAX_VALUE;

    /*
     * 치킨집 중 M개를 고르는 조합을 백트래킹한다.
     * 각 집에서 선택한 치킨집까지의 최소 거리 합을 계산해 도시 치킨 거리의 최솟값을 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        targetCount = Integer.parseInt(st.nextToken());

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col = 0; col < size; col++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1) houses.add(new int[]{row, col});
                else if (value == 2) stores.add(new int[]{row, col});
            }
        }

        selected = new boolean[stores.size()];
        choose(0, 0);

        System.out.print(answer);
    }

    static void choose(int start, int count) {
        if (count == targetCount) {
            answer = Math.min(answer, cityDistance());
            return;
        }

        for (int index = start; index < stores.size(); index++) {
            selected[index] = true;
            choose(index + 1, count + 1);
            selected[index] = false;
        }
    }

    static int cityDistance() {
        int total = 0;

        for (int[] house : houses) {
            int minimum = Integer.MAX_VALUE;

            for (int index = 0; index < stores.size(); index++) {
                if (!selected[index]) continue;

                int[] store = stores.get(index);
                minimum = Math.min(
                        minimum,
                        Math.abs(house[0] - store[0]) + Math.abs(house[1] - store[1])
                );
            }

            total += minimum;
        }

        return total;
    }
}
