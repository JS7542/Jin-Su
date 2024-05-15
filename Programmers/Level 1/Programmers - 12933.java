import java.util.*;

class Solution {
    /*
     * 정수의 각 자리수를 문자 배열로 변환해 오름차순 정렬한다.
     * 배열을 뒤집어 내림차순 숫자 문자열을 만들고 long으로 변환한다.
     */
    public long solution(long n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return Long.parseLong(new StringBuilder(new String(digits)).reverse().toString());
    }
}
