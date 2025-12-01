import java.io.*;
import java.util.*;

class Main {
    static class Village {
        long position;
        long people;

        Village(long position, long people) {
            this.position = position;
            this.people = people;
        }
    }

    /*
     * 마을을 위치순으로 정렬하고 전체 인구의 절반 이상이 누적되는 첫 위치를 찾는다.
     * 가중 중앙값 위치가 사람별 이동 거리 합을 최소화한다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Village[] villages = new Village[n];
        long totalPeople = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long position = Long.parseLong(st.nextToken());
            long people = Long.parseLong(st.nextToken());

            villages[i] = new Village(position, people);
            totalPeople += people;
        }

        Arrays.sort(villages, Comparator.comparingLong(village -> village.position));

        long target = (totalPeople + 1) / 2;
        long accumulated = 0;

        for (Village village : villages) {
            accumulated += village.people;

            if (accumulated >= target) {
                System.out.print(village.position);
                return;
            }
        }
    }
}
