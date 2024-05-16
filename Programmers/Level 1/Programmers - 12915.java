import java.util.*;
class Solution {
    /*
     * 각 문자열의 n번째 문자를 우선 비교하고 같으면 문자열 전체를 사전순 비교한다.
     * 사용자 정의 비교자로 배열을 정렬해 반환한다.
     */
    public String[] solution(String[] strings,int n){Arrays.sort(strings,(a,b)->a.charAt(n)!=b.charAt(n)?Character.compare(a.charAt(n),b.charAt(n)):a.compareTo(b));return strings;}
}
