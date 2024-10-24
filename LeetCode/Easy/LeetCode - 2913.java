import java.util.*;

class Solution {
    /*
     * 각 시작 위치에서 끝 위치를 늘리며 서로 다른 원소 집합을 유지한다.
     * 매 구간의 서로 다른 원소 개수 제곱을 결과에 더한다.
     */
    public int sumCounts(List<Integer> nums) {
        int answer = 0;

        for (int start = 0; start < nums.size(); start++) {
            Set<Integer> distinct = new HashSet<>();

            for (int end = start; end < nums.size(); end++) {
                distinct.add(nums.get(end));
                answer += distinct.size() * distinct.size();
            }
        }

        return answer;
    }
}
