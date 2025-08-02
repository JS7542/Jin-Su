import java.io.*;
import java.util.*;

class Main {
    static class Station {
        int distance;
        int fuel;

        Station(int distance, int fuel) {
            this.distance = distance;
            this.fuel = fuel;
        }
    }

    /*
     * 현재 연료로 도달 가능한 주유소의 연료량을 최대 힙에 넣는다.
     * 더 진행할 수 없을 때 가장 많은 연료를 주는 주유소를 선택한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Station[] stations = new Station[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stations[i] = new Station(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int destination = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        Arrays.sort(stations, Comparator.comparingInt(station -> station.distance));

        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        int stops = 0;

        while (fuel < destination) {
            while (index < n && stations[index].distance <= fuel) {
                available.offer(stations[index].fuel);
                index++;
            }

            if (available.isEmpty()) {
                System.out.print(-1);
                return;
            }

            fuel += available.poll();
            stops++;
        }

        System.out.print(stops);
    }
}
