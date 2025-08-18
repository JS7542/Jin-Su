import java.util.*;

class Solution {
    /*
     * 원하는 상품 수량을 해시맵에 저장하고 열흘 길이 슬라이딩 윈도우의 상품 빈도를 관리한다.
     * 매 시작일마다 모든 필요 수량을 만족하는지 확인해 가능한 회원가입 날짜를 센다.
     */
    public int solution(
            String[] want,
            int[] number,
            String[] discount
    ) {
        Map<String, Integer> required = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            required.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();
        int answer = 0;

        for (int day = 0; day < discount.length; day++) {
            window.put(
                    discount[day],
                    window.getOrDefault(discount[day], 0) + 1
            );

            if (day >= 10) {
                String removed = discount[day - 10];
                window.put(removed, window.get(removed) - 1);
            }

            if (day >= 9 && matches(required, window)) answer++;
        }

        return answer;
    }

    private boolean matches(
            Map<String, Integer> required,
            Map<String, Integer> window
    ) {
        for (Map.Entry<String, Integer> entry : required.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0)
                    != entry.getValue()) return false;
        }

        return true;
    }
}
