import java.util.*;

class Solution {
    /*
     * 2부터 시작해 n을 나누어떨어지게 하는 인수를 찾는다.
     * 같은 인수는 한 번만 저장하고 가능한 만큼 나눈 뒤 다음 수로 이동한다.
     */
    public int[] solution(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) {
                factors.add(divisor);
                while (n % divisor == 0) n /= divisor;
            }
        }

        if (n > 1) factors.add(n);
        return factors.stream().mapToInt(Integer::intValue).toArray();
    }
}
