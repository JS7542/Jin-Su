import java.util.*;

class Solution {
    /*
     * 모든 날짜를 한 달 28일 기준의 정수 일수로 변환한다.
     * 수집일에 약관 개월 수를 더한 만료일보다 오늘이 늦으면 파기 대상이다.
     */
    public int[] solution(
            String today,
            String[] terms,
            String[] privacies
    ) {
        Map<String, Integer> months = new HashMap<>();

        for (String term : terms) {
            String[] parts = term.split(" ");
            months.put(parts[0], Integer.parseInt(parts[1]));
        }

        int todayValue = dateValue(today);
        List<Integer> expired = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int expiration = dateValue(parts[0])
                    + months.get(parts[1]) * 28 - 1;

            if (todayValue > expiration) expired.add(i + 1);
        }

        return expired.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dateValue(String date) {
        String[] parts = date.split("\\.");

        return Integer.parseInt(parts[0]) * 12 * 28
                + Integer.parseInt(parts[1]) * 28
                + Integer.parseInt(parts[2]);
    }
}
