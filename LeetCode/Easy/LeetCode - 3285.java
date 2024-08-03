import java.util.*;

class Solution {
    /*
     * 인덱스 i의 직전 산 높이가 threshold보다 큰지 확인한다.
     * 조건을 만족하는 i를 결과 리스트에 추가한다.
     */
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) answer.add(i);
        }

        return answer;
    }
}
