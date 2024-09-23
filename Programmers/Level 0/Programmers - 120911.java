import java.util.*;
class Solution {
    /*
     * 문자열을 소문자로 바꾸고 문자 배열로 변환한다.
     * 오름차순 정렬한 배열을 문자열로 만들어 반환한다.
     */
    public String solution(String my_string){char[]a=my_string.toLowerCase().toCharArray();Arrays.sort(a);return new String(a);}
}
