import java.util.*;

class Solution {
    /*
     * n의 값에 따라 시작 인덱스, 끝 인덱스, 간격을 결정한다.
     * 선택된 인덱스의 원소를 순서대로 결과 배열에 담는다.
     */
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int start = 0;
        int end = num_list.length - 1;
        int step = 1;

        if (n == 1) end = slicer[1];
        else if (n == 2) start = slicer[0];
        else if (n == 3) {
            start = slicer[0];
            end = slicer[1];
        } else {
            start = slicer[0];
            end = slicer[1];
            step = slicer[2];
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = start; i <= end; i += step) answer.add(num_list[i]);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
