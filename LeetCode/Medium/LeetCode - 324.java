import java.util.*;

class Solution {
    /*
     * 배열을 정렬하고 작은 절반과 큰 절반을 뒤에서부터 번갈아 배치한다.
     * 짝수 인덱스에는 작은 값, 홀수 인덱스에는 큰 값을 넣어 엄격한 지그재그 순서를 만든다.
     */
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;

        for (int index = 0; index < nums.length; index++) {
            if (index % 2 == 0) nums[index] = sorted[left--];
            else nums[index] = sorted[right--];
        }
    }
}
