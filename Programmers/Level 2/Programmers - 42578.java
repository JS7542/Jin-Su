import java.util.*;

class Solution {
    /*
     * 의상 종류별 개수를 해시맵에 센다.
     * 각 종류에서 하나를 고르거나 고르지 않는 경우를 곱하고 아무것도 안 입는 경우를 뺀다.
     */
    public int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<>();

        for (String[] item : clothes) {
            counts.put(item[1], counts.getOrDefault(item[1], 0) + 1);
        }

        int answer = 1;
        for (int count : counts.values()) answer *= count + 1;

        return answer - 1;
    }
}
