import java.util.*;

class Solution {
    /*
     * 크루 도착 시각을 정렬하고 각 셔틀에 정원만큼 순서대로 태운다.
     * 마지막 셔틀에 자리가 남으면 출발 시각, 가득 차면 마지막 탑승자보다 1분 일찍 도착한다.
     */
    public String solution(int n, int t, int m, String[] timetable) {
        int[] arrivals = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            arrivals[i] = minutes(timetable[i]);
        }

        Arrays.sort(arrivals);

        int crewIndex = 0;
        int answer = 0;

        for (int bus = 0; bus < n; bus++) {
            int departure = 9 * 60 + bus * t;
            int boarded = 0;
            int lastBoarded = -1;

            while (crewIndex < arrivals.length
                    && arrivals[crewIndex] <= departure
                    && boarded < m) {
                lastBoarded = arrivals[crewIndex++];
                boarded++;
            }

            if (bus == n - 1) {
                answer = boarded < m ? departure : lastBoarded - 1;
            }
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }

    private int minutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
