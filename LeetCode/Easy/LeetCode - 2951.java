import java.util.*;

class Solution {
    /*
     * 양 끝을 제외한 각 위치를 확인한다.
     * 양쪽 이웃보다 큰 값의 인덱스를 결과에 추가한다.
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i + 1 < mountain.length; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                answer.add(i);
            }
        }

        return answer;
    }
}
