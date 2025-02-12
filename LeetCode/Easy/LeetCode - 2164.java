import java.util.*;

class Solution {
    /*
     * 짝수 인덱스 값과 홀수 인덱스 값을 각각 별도 배열에 저장해 정렬한다.
     * 짝수 위치는 오름차순, 홀수 위치는 내림차순으로 다시 배치한다.
     */
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }

        Collections.sort(even);
        odd.sort(Collections.reverseOrder());

        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? even.get(evenIndex++) : odd.get(oddIndex++);
        }

        return nums;
    }
}
