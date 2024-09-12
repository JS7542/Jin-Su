class Solution {
    /*
     * 공백으로 분리된 두 피연산자와 연산자를 읽는다.
     * +, -, * 연산에 따라 계산 결과를 반환한다.
     */
    public int solution(String binomial) {
        String[] parts = binomial.split(" ");
        int first = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[2]);

        if (parts[1].equals("+")) return first + second;
        if (parts[1].equals("-")) return first - second;
        return first * second;
    }
}
