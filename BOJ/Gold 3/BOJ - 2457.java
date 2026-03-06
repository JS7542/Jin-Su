import java.io.*;
import java.util.*;

class Main {
    static class Flower {
        int start;
        int end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /*
     * 꽃이 피는 날짜순으로 정렬하고 현재 덮인 날짜 안에서 가장 늦게 지는 꽃을 선택한다.
     * 3월 1일부터 11월 30일까지 끊김 없이 덮는 최소 꽃 개수를 구한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Flower[] flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(
                    startMonth * 100 + startDay,
                    endMonth * 100 + endDay
            );
        }

        Arrays.sort(flowers, (a, b) -> {
            int compare = Integer.compare(a.start, b.start);
            return compare != 0 ? compare : Integer.compare(b.end, a.end);
        });

        int currentEnd = 301;
        int target = 1201;
        int index = 0;
        int answer = 0;

        while (currentEnd < target) {
            int nextEnd = currentEnd;

            while (index < n && flowers[index].start <= currentEnd) {
                nextEnd = Math.max(nextEnd, flowers[index].end);
                index++;
            }

            if (nextEnd == currentEnd) {
                System.out.print(0);
                return;
            }

            currentEnd = nextEnd;
            answer++;
        }

        System.out.print(answer);
    }
}
