class Solution {
    /*
     * 각 문자를 알파벳 순번으로 바꾸고 그 순번의 자리수를 합산한다.
     * 이후 k-1번 동안 현재 숫자의 자리수 합을 반복 계산한다.
     */
    public int getLucky(String s, int k) {
        int value = 0;

        for (char ch : s.toCharArray()) {
            int number = ch - 'a' + 1;
            value += number / 10 + number % 10;
        }

        for (int transform = 1; transform < k; transform++) {
            value = digitSum(value);
        }

        return value;
    }

    private int digitSum(int value) {
        int sum = 0;

        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }

        return sum;
    }
}
