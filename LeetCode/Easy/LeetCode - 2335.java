import java.util.*;

class Solution {
    /*
     * 가장 많은 양이 전체 나머지를 모두 흡수할 수 있는지 확인한다.
     * 그렇지 않으면 전체 양을 두 잔씩 처리한 올림값이 최소 시간이다.
     */
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int sum = amount[0] + amount[1] + amount[2];
        return Math.max(amount[2], (sum + 1) / 2);
    }
}
