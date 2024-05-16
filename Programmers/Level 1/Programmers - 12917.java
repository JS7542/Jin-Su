import java.util.*;
class Solution {
    /*
     * 문자열을 문자 배열로 바꾸고 오름차순으로 정렬한다.
     * 뒤집은 결과를 반환해 내림차순 문자열을 만든다.
     */
    public String solution(String s){char[]a=s.toCharArray();Arrays.sort(a);return new StringBuilder(new String(a)).reverse().toString();}
}
