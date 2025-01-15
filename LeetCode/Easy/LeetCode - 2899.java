import java.util.*;

class Solution {
    /*
     * 숫자는 최근 목록의 앞에 추가하고 prev는 연속 등장 횟수를 증가시킨다.
     * prev 횟수에 해당하는 최근 숫자가 없으면 -1을 결과에 추가한다.
     */
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> recent = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int previousCount = 0;

        for (String word : words) {
            if (word.equals("prev")) {
                previousCount++;
                answer.add(previousCount <= recent.size() ? recent.get(previousCount - 1) : -1);
            } else {
                recent.add(0, Integer.parseInt(word));
                previousCount = 0;
            }
        }

        return answer;
    }
}
