class Solution {
    /*
     * a 뒤에 b를 붙인 수와 b 뒤에 a를 붙인 수를 만든다.
     * 두 정수 중 더 큰 값을 반환한다.
     */
    public int solution(int a, int b) {
        int first = Integer.parseInt(String.valueOf(a) + b);
        int second = Integer.parseInt(String.valueOf(b) + a);
        return Math.max(first, second);
    }
}
