import java.util.*;

class Solution {
    /*
     * 두 사람이 교환 후 같은 합을 가지려면 Alice의 값과 Bob의 값 차이가 합 차이의 절반이어야 한다.
     * Bob의 값을 집합에 저장하고 조건을 만족하는 쌍을 찾는다.
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        for (int value : aliceSizes) aliceSum += value;
        for (int value : bobSizes) bobSum += value;

        int difference = (aliceSum - bobSum) / 2;
        Set<Integer> bob = new HashSet<>();
        for (int value : bobSizes) bob.add(value);

        for (int value : aliceSizes) {
            if (bob.contains(value - difference)) {
                return new int[]{value, value - difference};
            }
        }

        return new int[0];
    }
}
