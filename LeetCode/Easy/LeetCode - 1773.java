import java.util.*;

class Solution {
    /*
     * ruleKey에 따라 type, color, name 중 비교할 인덱스를 결정한다.
     * 해당 위치 값이 ruleValue와 같은 항목의 개수를 센다.
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int answer = 0;

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) answer++;
        }

        return answer;
    }
}
