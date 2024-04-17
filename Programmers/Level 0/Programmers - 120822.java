class Solution {
    /*
     * StringBuilder의 reverse 메서드로 문자열의 문자 순서를 뒤집는다.
     * 뒤집힌 결과를 문자열로 변환해 반환한다.
     */
    public String solution(String my_string) {
        return new StringBuilder(my_string).reverse().toString();
    }
}
