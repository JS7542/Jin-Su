class Solution {
    /*
     * 큰 숫자 문자열의 각 자리수를 합산한다.
     * 자리수 합을 9로 나눈 나머지는 원래 수의 나머지와 같다.
     */
    public int solution(String number) {
        int sum = 0;
        for (char ch : number.toCharArray()) sum += ch - '0';
        return sum % 9;
    }
}
