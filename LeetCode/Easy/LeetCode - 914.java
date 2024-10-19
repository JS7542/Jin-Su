import java.util.*;

class Solution {
    /*
     * 카드 숫자별 빈도수를 센 뒤 모든 빈도의 최대공약수를 계산한다.
     * 공약수가 2 이상이면 같은 크기의 그룹으로 나눌 수 있다.
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : deck) count.put(card, count.getOrDefault(card, 0) + 1);

        int gcd = 0;
        for (int value : count.values()) gcd = gcd(gcd, value);
        return gcd >= 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
