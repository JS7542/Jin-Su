import java.util.*;

class Solution {
    /*
     * 마지막 원소가 그 앞 원소보다 크면 두 값의 차를 추가한다.
     * 그렇지 않으면 마지막 원소의 두 배를 배열 끝에 추가한다.
     */
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);
        int last = num_list[num_list.length - 1];
        int previous = num_list[num_list.length - 2];

        answer[answer.length - 1] = last > previous ? last - previous : last * 2;
        return answer;
    }
}
