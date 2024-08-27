import java.math.*;

class Solution {
    /*
     * 매우 큰 두 정수 문자열을 BigInteger로 변환한다.
     * 두 수를 더한 결과를 다시 문자열로 반환한다.
     */
    public String solution(String a, String b) {
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }
}
