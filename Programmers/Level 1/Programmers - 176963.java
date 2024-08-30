import java.util.*;

class Solution {
    /*
     * 사람 이름과 그리움 점수를 해시맵에 저장한다.
     * 각 사진에 등장하는 사람의 점수를 합산해 결과 배열을 만든다.
     */
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < name.length; i++) score.put(name[i], yearning[i]);

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (String person : photo[i]) {
                answer[i] += score.getOrDefault(person, 0);
            }
        }

        return answer;
    }
}
