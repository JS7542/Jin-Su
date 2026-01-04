import java.util.*;

class Solution {
    /*
     * 두 문자열에서 영문자 두 글자 조각의 다중집합을 만든다.
     * 각 조각의 최소 빈도는 교집합, 최대 빈도는 합집합 크기에 더한다.
     */
    public int solution(String str1, String str2) {
        Map<String, Integer> first = build(str1.toLowerCase());
        Map<String, Integer> second = build(str2.toLowerCase());

        Set<String> keys = new HashSet<>();
        keys.addAll(first.keySet());
        keys.addAll(second.keySet());

        int intersection = 0;
        int union = 0;

        for (String key : keys) {
            int left = first.getOrDefault(key, 0);
            int right = second.getOrDefault(key, 0);
            intersection += Math.min(left, right);
            union += Math.max(left, right);
        }

        if (union == 0) return 65536;
        return (int) ((long) intersection * 65536 / union);
    }

    private Map<String, Integer> build(String text) {
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i + 1 < text.length(); i++) {
            char first = text.charAt(i);
            char second = text.charAt(i + 1);

            if (!Character.isLetter(first) || !Character.isLetter(second)) continue;

            String piece = "" + first + second;
            count.put(piece, count.getOrDefault(piece, 0) + 1);
        }

        return count;
    }
}
