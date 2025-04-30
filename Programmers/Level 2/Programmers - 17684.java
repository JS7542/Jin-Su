import java.util.*;

class Solution {
    /*
     * 기본 알파벳 사전을 만들고 현재 위치에서 가장 긴 등록 문자열을 찾는다.
     * 해당 색인을 출력하고 다음 문자까지 포함한 문자열을 사전에 추가한다.
     */
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) dictionary.put(String.valueOf((char) ('A' + i)), i + 1);

        List<Integer> answer = new ArrayList<>();
        int nextIndex = 27;
        int position = 0;

        while (position < msg.length()) {
            int end = position + 1;

            while (end <= msg.length()
                    && dictionary.containsKey(msg.substring(position, end))) {
                end++;
            }

            String current = msg.substring(position, end - 1);
            answer.add(dictionary.get(current));

            if (end <= msg.length()) {
                dictionary.put(msg.substring(position, end), nextIndex++);
            }

            position = end - 1;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
