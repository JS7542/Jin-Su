import java.util.*;

class Solution {
    /*
     * 네 자리 숫자의 각 자리수를 배열에 넣고 오름차순으로 정렬한다.
     * 작은 두 숫자를 십의 자리에 배치해 두 수의 합을 최소화한다.
     */
    public int minimumSum(int num) {
        int[] digits = new int[4];

        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(digits);
        return (digits[0] + digits[1]) * 10 + digits[2] + digits[3];
    }
}
