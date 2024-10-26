import java.util.*;

class Solution {
    /*
     * 각 문자열의 등장 횟수를 해시맵에 저장한다.
     * 원본 순서대로 한 번만 등장한 문자열을 세어 k번째 값을 반환한다.
     */
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String text : arr) count.put(text, count.getOrDefault(text, 0) + 1);

        for (String text : arr) {
            if (count.get(text) == 1 && --k == 0) return text;
        }

        return "";
    }
}
