import java.util.*;
class Solution {
    /*
     * 배열을 왼쪽부터 보며 바로 이전에 저장한 값과 다른 경우만 결과에 추가한다.
     * 연속 중복을 제거하되 전체 순서는 유지한다.
     */
    public int[] solution(int[] arr){List<Integer>l=new ArrayList<>();for(int x:arr)if(l.isEmpty()||l.get(l.size()-1)!=x)l.add(x);return l.stream().mapToInt(Integer::intValue).toArray();}
}
