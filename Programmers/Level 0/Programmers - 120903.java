import java.util.*;
class Solution {
    /*
     * 첫 문자열 배열의 원소를 HashSet에 저장한다.
     * 두 번째 배열에서 집합에 포함된 문자열의 개수를 센다.
     */
    public int solution(String[] s1,String[] s2){Set<String>s=new HashSet<>(Arrays.asList(s1));int answer=0;for(String x:s2)if(s.contains(x))answer++;return answer;}
}
