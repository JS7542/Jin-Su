class Solution {
    /*
     * 홀수와 짝수를 각각 별도의 문자열에 입력 순서대로 이어 붙인다.
     * 두 문자열을 정수로 변환한 뒤 합을 반환한다.
     */
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int number : num_list) {
            if (number % 2 == 1) odd.append(number);
            else even.append(number);
        }

        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}
