import java.io.*;
import java.util.*;

class Main {
    static class Delivery {
        int from;
        int to;
        int boxes;

        Delivery(int from, int to, int boxes) {
            this.from = from;
            this.to = to;
            this.boxes = boxes;
        }
    }

    /*
     * 도착 마을이 빠른 배송부터 처리한다.
     * 이동 구간별 남은 용량의 최솟값만큼 싣고 해당 구간 사용량을 갱신한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int villages = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int deliveriesCount = Integer.parseInt(br.readLine());
        Delivery[] deliveries = new Delivery[deliveriesCount];

        for (int i = 0; i < deliveriesCount; i++) {
            st = new StringTokenizer(br.readLine());

            deliveries[i] = new Delivery(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(deliveries, (a, b) -> {
            int compare = Integer.compare(a.to, b.to);
            return compare != 0 ? compare : Integer.compare(a.from, b.from);
        });

        int[] loaded = new int[villages + 1];
        int answer = 0;

        for (Delivery delivery : deliveries) {
            int available = delivery.boxes;

            for (int village = delivery.from; village < delivery.to; village++) {
                available = Math.min(available, capacity - loaded[village]);
            }

            if (available <= 0) continue;

            for (int village = delivery.from; village < delivery.to; village++) {
                loaded[village] += available;
            }

            answer += available;
        }

        System.out.print(answer);
    }
}
