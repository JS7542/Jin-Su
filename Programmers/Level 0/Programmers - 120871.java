class Solution {
    /*
     * 자연수를 하나씩 증가시키며 3의 배수이거나 숫자 3이 포함된 수를 건너뛴다.
     * 조건을 통과한 수를 n번 셌을 때의 값을 반환한다.
     */
    public int solution(int n) {
        int count = 0;
        int value = 0;

        while (count < n) {
            value++;
            if (value % 3 != 0 && !String.valueOf(value).contains("3")) count++;
        }

        return value;
    }
}
