import java.util.*;

class Solution {
    /*
     * 차량별 입차 시각과 누적 주차 시간을 해시맵에 저장한다.
     * 출차 기록이 없는 차량은 23:59에 출차한 것으로 처리해 차량 번호순 요금을 계산한다.
     */
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> entered = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            int time = toMinutes(parts[0]);
            String car = parts[1];

            if (parts[2].equals("IN")) {
                entered.put(car, time);
            } else {
                int duration = time - entered.remove(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + duration);
            }
        }

        for (Map.Entry<String, Integer> entry : entered.entrySet()) {
            String car = entry.getKey();
            int duration = 23 * 60 + 59 - entry.getValue();

            totalTime.put(car, totalTime.getOrDefault(car, 0) + duration);
        }

        int[] answer = new int[totalTime.size()];
        int index = 0;

        for (int time : totalTime.values()) {
            int fee = fees[1];

            if (time > fees[0]) {
                fee += (time - fees[0] + fees[2] - 1) / fees[2] * fees[3];
            }

            answer[index++] = fee;
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
