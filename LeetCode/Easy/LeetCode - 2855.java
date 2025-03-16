import java.util.*;

class Solution {
    /*
     * 배열이 감소하는 경계가 두 번 이상이면 회전으로 정렬할 수 없다.
     * 한 번만 감소한다면 그 경계 뒤 원소 수가 필요한 오른쪽 이동 횟수다.
     */
    public int minimumRightShifts(List<Integer> nums) {
        int drops = 0;
        int pivot = 0;
        int n = nums.size();

        for (int i = 0; i + 1 < n; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                drops++;
                pivot = i + 1;
            }
        }

        if (drops == 0) return 0;
        if (drops > 1 || nums.get(n - 1) > nums.get(0)) return -1;
        return n - pivot;
    }
}
