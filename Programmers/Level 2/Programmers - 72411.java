import java.util.*;

class Solution {
    /*
     * 각 주문 문자열을 정렬하고 원하는 코스 길이별 조합을 생성한다.
     * 두 번 이상 등장한 조합 중 각 길이에서 최대 빈도인 메뉴만 결과에 추가한다.
     */
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int size : course) {
            Map<String, Integer> count = new HashMap<>();

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combine(chars, size, 0, new StringBuilder(), count);
            }

            int maximum = 0;

            for (int value : count.values()) {
                if (value >= 2) maximum = Math.max(maximum, value);
            }

            if (maximum < 2) continue;

            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                if (entry.getValue() == maximum) answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void combine(
            char[] chars,
            int target,
            int start,
            StringBuilder current,
            Map<String, Integer> count
    ) {
        if (current.length() == target) {
            String menu = current.toString();
            count.put(menu, count.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int index = start; index < chars.length; index++) {
            current.append(chars[index]);
            combine(chars, target, index + 1, current, count);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
