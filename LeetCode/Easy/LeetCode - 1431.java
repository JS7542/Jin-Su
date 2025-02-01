import java.util.*;

class Solution {
    /*
     * 현재 가장 많은 사탕 수를 먼저 찾는다.
     * 각 아이에게 extraCandies를 더했을 때 최댓값 이상인지 결과에 저장한다.
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) max = Math.max(max, candy);

        List<Boolean> answer = new ArrayList<>();
        for (int candy : candies) answer.add(candy + extraCandies >= max);
        return answer;
    }
}
