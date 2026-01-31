import java.util.*;

class Solution {
    /*
     * 숫자 문자의 모든 길이 순열을 백트래킹으로 만든다.
     * 생성된 정수를 집합에 저장하고 소수인 서로 다른 값의 개수를 센다.
     */
    public int solution(String numbers) {
        Set<Integer> values = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];
        build(numbers, used, new StringBuilder(), values);

        int answer = 0;
        for (int value : values) if (isPrime(value)) answer++;
        return answer;
    }

    private void build(
            String numbers,
            boolean[] used,
            StringBuilder current,
            Set<Integer> values
    ) {
        if (current.length() > 0) values.add(Integer.parseInt(current.toString()));

        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            current.append(numbers.charAt(i));
            build(numbers, used, current, values);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    private boolean isPrime(int value) {
        if (value < 2) return false;

        for (int divisor = 2; divisor * divisor <= value; divisor++) {
            if (value % divisor == 0) return false;
        }

        return true;
    }
}
